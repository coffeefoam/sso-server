/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.cache.CacheWrapper;
import net.yoomai.db.GrantTicketDAO;
import net.yoomai.model.GrantTicket;
import net.yoomai.model.User;
import net.yoomai.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;


/**
 * @(#)TickitService.java 1.0 14/09/2012
 * <p/>
 * Ticket生成和验证的服务模块.
 */
public class TicketService {
	@Inject
	private CacheWrapper cache;
	private GrantTicketDAO gtdao;

	private Logger log = Logger.getLogger(TicketService.class);

	@Inject
	public TicketService(GrantTicketDAO gtdao) {
		this.gtdao = gtdao;
	}

	/**
	 * 第一步，验证TGT是否在cookie中存在标识，如果存在，则把标示返回.
	 *
	 * @param cookies
	 * @return
	 */
	public String verifyTGT(Cookie[] cookies) {
		String _tgt_id = null;

		if (cookies != null) {
			for (int index = 0; index < cookies.length; index++) {
				Cookie cookie = cookies[index];
				if ("_id_".equals(cookie.getName())) {
					_tgt_id = cookie.getValue();
				}
			}
		}

		return _tgt_id;
	}

	/**
	 * 第二步，验证库里是否存在真实的ticket标识，如果有，则返回真实的ticket，如果没有，则返回null
	 *
	 * @param uid
	 * @return
	 */
	public String verifyTGT(String uid) {
//		GrantTicket gt = gtdao.find(tgtId);
		// 暂时从缓存中取出相应的数据
		Object gt =cache.get(Long.valueOf(uid));
		if (gt == null) {
			return null;
		}
//		return ((GrantTicket)gt).getTicket();
		return (String) gt;
	}

	/**
	 * 生成新的TGT
	 *
	 * @param user
	 * @return
	 */
	public GrantTicket generateTGT(User user, String ip) {
		GrantTicket gt = new GrantTicket();
		gt.setLastIp(ip);
		gt.setLastTime(new Date());
		gt.setTicket(DigestUtils.md5Hex(user.getUid() + "|" + ip));
		gt.setUid(user.getUid());
		gt.setSid("");

		cache.put(user.getUid(), gt.getTicket());

		return gt;
	}

	/**
	 * 根据相应的应用编码与TGT，分配相应的ST
	 *
	 * @param appId
	 * @return
	 */
	public String generateST(String appId, String service, long uid) throws UnsupportedEncodingException {
		String encryptContent = appId + "|" + service + "|" + uid + "|" + StringUtils.getUniqueID(8);
//		TeaCryptor cry = new TeaCryptor();
//		String st = URLEncoder.encode(BASE64Coding.encode(cry.encrypt(encryptContent.getBytes(), GlobalConfig.get("key").getBytes())), "UTF-8");
		String st = StringUtils.MD5(encryptContent);
		cache.put(st, encryptContent);
		log.debug("I put service ticket [" + st + "] into cache yet.");
		return st;
	}


	/**
	 * 验证ST，成功返回新的ticket，否则返回null
	 *
	 * @param appId
	 * @return
	 */
	public String verifyST(String appId, String service, String ticket) throws UnsupportedEncodingException {
		log.debug(ticket + " will be verify.");

		Object obj = cache.get(ticket);
		if (obj == null) {
			log.debug("Sorry, service ticket [" + ticket + "] is not in cache, fuck.");
			return null;
		} else {
			cache.remove(ticket);
			String[] items = String.valueOf(obj).split("\\|");
			if (items.length != 4) {
				return null;
			}
			return generateST(appId, service, Long.valueOf(items[2]));
		}
	}

	public String[] getItems(String st) throws UnsupportedEncodingException {
		Object obj = cache.get(st);
		if (obj == null) {
			log.debug("I want to read ticket(" + st + ") string from cache, but it is null");
			return null;
		}

		String[] items = String.valueOf(obj).split("\\|");
		if (items.length != 4) {
			log.debug("items length: " + items.length);
			return null;
		}
		cache.remove(st);
		String ticket = generateST(items[0], items[1], Long.parseLong(items[2]));

		String[] items2 = Arrays.copyOf(items, 5);
		items2[4] = ticket;
		return items2;
	}
}