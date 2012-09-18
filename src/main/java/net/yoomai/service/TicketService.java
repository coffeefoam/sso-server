/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.cache.CacheWrapper;
import net.yoomai.model.GrantTicket;
import net.yoomai.model.User;
import net.yoomai.util.StringUtils;
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

	public TicketService() {
	}

	/**
	 * 生成和验证TGT的接口
	 *
	 * @return
	 */
	public String generateTGT(Cookie[] cookies, User user) {
		String _tgt_id = "";

		if (cookies != null) {
			for (int index = 0; index < cookies.length; index++) {
				Cookie cookie = cookies[index];
				if ("_id_".equals(cookie.getName())) {
					_tgt_id = cookie.getValue();
				}
			}
		}
		Object obj = cache.get(_tgt_id);
		if (obj == null) {
			// 生成一个TGT标识
			GrantTicket gt = generateTGT(user.getUid(), user.getLastIp());

			_tgt_id = gt.getId();
		} else {
			GrantTicket gt = (GrantTicket) obj;
			_tgt_id = gt.getId();
		}

		return _tgt_id;
	}

	/**
	 * 用于生成TGT
	 *
	 * @return
	 */
	private GrantTicket generateTGT(long uid, String ip) {
		GrantTicket gt = new GrantTicket();

		String id = StringUtils.getUniqueID(10);
		gt.setId(id);
		gt.setUid(uid);
		gt.setIp(ip);
		gt.setGrantTime(new Date());
		gt.setTicket(DigestUtils.md5Hex(id + "|" + ip));

		return gt;
	}
}
