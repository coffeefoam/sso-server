/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import cn.com.opensource.crypto.BASE64Coding;
import com.google.inject.Inject;
import net.yoomai.cache.CacheWrapper;
import net.yoomai.config.GlobalConfig;
import net.yoomai.db.GrantTicketDAO;
import net.yoomai.model.GrantTicket;
import net.yoomai.model.User;
import net.yoomai.util.TeaCryptor;

import javax.servlet.http.Cookie;
import java.io.Serializable;
import java.util.Date;

/**
 * @(#)TickitService.java 1.0 14/09/2012
 * <p/>
 * Ticket生成和验证的服务模块.
 */
public class TicketService {
	@Inject
	private CacheWrapper<Serializable, Serializable> cache;
	private GrantTicketDAO gtdao;

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
	 * @param tgtId
	 * @return
	 */
	public String verifyTGT(String tgtId) {
//		GrantTicket gt = gtdao.find(tgtId);
		// 暂时从缓存中取出相应的数据
		Object gt =cache.get(tgtId);
		if (gt == null) {
			return null;
		}
		return ((GrantTicket)gt).getTicket();
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
		gt.setTicket(user.getUid() + "|" + ip);
		gt.setUid(user.getUid());
		gt.setSid("");

		cache.put(user.getUid(), gt);

		return gt;
	}

	/**
	 * 根据相应的应用编码与TGT，分配相应的ST
	 *
	 * @param appId
	 * @return
	 */
	public String generateST(String appId, String service) {
		String encryptContent = appId + "|" + service + "|" + new Date().getTime();
		TeaCryptor cry = new TeaCryptor();
		String st = BASE64Coding.encode(cry.encrypt(encryptContent.getBytes(), GlobalConfig.get("key").getBytes()));
		cache.put(st, encryptContent);
		return st;
	}


	/**
	 * 验证ST，成功返回新的ticket，否则返回null
	 *
	 * @param appId
	 * @return
	 */
	public String verifyST(String appId, String service, String ticket) {
		Object obj = cache.get(ticket);
		if (obj == null) {
			return null;
		} else {
			TeaCryptor cry = new TeaCryptor();
			byte [] bs = BASE64Coding.decode(ticket);
			if (bs == null) {
				return null;
			}
			byte[] bs2 = cry.decrypt(bs, GlobalConfig.get("key").getBytes());
			if (bs2 == null) {
				return null;
			}
			String encryptContent = new String(bs2);
			if (encryptContent.equals(String.valueOf(obj))) {
				cache.remove(appId);
				return generateST(appId, service);
			}

			return null;
		}
	}
}
