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
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
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
		GrantTicket gt = gtdao.find(tgtId);
		if (gt == null) {
			return null;
		}
		return gt.getTicket();
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
		String st = DigestUtils.md5Hex(appId + "|" + service + "|" + new Date().getTime());
		cache.put(st, appId + "|" + service + "|");
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
			cache.remove(appId);
			String newTicket = generateST(appId, service);
			return newTicket;
		}
	}
}
