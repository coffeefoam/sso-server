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
import java.util.Date;


/**
 * @(#)TickitService.java 1.0 14/09/2012
 * <p/>
 * Ticket���ɺ���֤�ķ���ģ��.
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
	 * ��һ������֤TGT�Ƿ���cookie�д��ڱ�ʶ��������ڣ���ѱ�ʾ����.
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
	 * �ڶ�������֤�����Ƿ������ʵ��ticket��ʶ������У��򷵻���ʵ��ticket�����û�У��򷵻�null
	 *
	 * @param uid
	 * @return
	 */
	public String verifyTGT(String uid) {
//		GrantTicket gt = gtdao.find(tgtId);
		// ��ʱ�ӻ�����ȡ����Ӧ������
		Object gt =cache.get(Long.valueOf(uid));
		if (gt == null) {
			return null;
		}
//		return ((GrantTicket)gt).getTicket();
		return (String) gt;
	}

	/**
	 * �����µ�TGT
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
	 * ������Ӧ��Ӧ�ñ�����TGT��������Ӧ��ST
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
	 * ��֤ST���ɹ������µ�ticket�����򷵻�null
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

	public String[] getItems(String st) {
		Object obj = cache.get(st);
		if (obj == null) {
			log.debug("I want to read ticket string from cache, but it is null");
			return null;
		}

		String[] items = String.valueOf(obj).split("\\|");
		if (items.length != 4) {
			log.debug("items length: " + items.length);
			return null;
		}
		return items;
	}
}