/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import net.yoomai.model.GrantTicket;
import net.yoomai.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @(#)TickitService.java 1.0 14/09/2012
 * <p/>
 * Ticket生成和验证的服务模块.
 */
public class TicketService {
	// 暂时用于存放TGT
	private static Map map = new HashMap();
	// 暂时存放ST
	private static Map st = new HashMap();

	/**
	 * 生成和验证TGT的接口
	 *
	 * @param request
	 * @param response
	 * @return
  	public String generateTGT(HttpServletRequest request, HttpServletResponse response) {
		String _tgt_id = "";
		Cookie[] cookies = request.getCookies();
		for (int index = 0; index < cookies.length; index++) {
			Cookie cookie = cookies[index];
			if ("_id_".equals(cookie.getName())) {
				_tgt_id = cookie.getValue();	
			}
		}
		Object obj = map.get(_tgt_id);
		if (obj == null) {
			// 生成一个TGT标识
		} else {
			_tgt_id = (String) obj;
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

		byte[] tickets = DigestUtils.sha(id);


		return null;
	}
}
