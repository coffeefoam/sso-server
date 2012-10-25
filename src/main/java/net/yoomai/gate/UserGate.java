/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.sf.json.JSONObject;
import net.yoomai.model.User;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @(#)UserGate.java 1.0 25/10/2012
 * 默认是获取当前用户信息的接口，这个是根据业务需要来获取的
 */
@Singleton
public class UserGate extends AbstractGate {
	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _uid = ticketService.verifyTGT(request.getCookies());
		String result = "";

		if (_uid == null || "".equals(_uid)) {
			result = "";
		} else {
			User user = service.find(Long.parseLong(_uid));
			System.out.println(new String(user.getUsername().getBytes(), "gbk"));
			result = JSONObject.fromObject(user).toString();
		}

		Writer writer = response.getWriter();
		writer.write(result);
	}
}
