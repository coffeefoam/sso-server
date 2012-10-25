/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.model.GrantTicket;
import net.yoomai.model.User;
import net.yoomai.service.TemplateService;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @(#)LoginGate.java 1.0 18/09/2012
 *
 * 负责登陆页面显示，登录处理等逻辑转向
 */
@Singleton
public class LoginGate extends AbstractGate {
	@Inject
	private TemplateService templateService;
	@Inject
	private UserService userService;
	@Inject
	private TicketService ticketService;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = NetUtil.getStringParameter(request, "action", "");

		if ("signin".equals(action)) {
			// 处理登录请求
			long uid = NetUtil.getLongParameter(request, "uid", 0);
			String password = NetUtil.getStringParameter(request, "password", "");

			User user = userService.auth(uid, password);

			if (user == null) {
				response.sendRedirect("/login?" + makeParamURL(request));
			} else {
				// 登录成功，分配一个有效的TGT，后重定向到/auth
			    GrantTicket gt = ticketService.generateTGT(user, request.getRemoteAddr());

				Cookie cookie = new Cookie("_id_", String.valueOf(gt.getUid()));
				response.addCookie(cookie);
				response.sendRedirect("/auth?" + makeParamURL(request));
				return;
			}
		} else {
			// 显示登录界面
	 	    response.getWriter().write(templateService.paint(makeParamMap(request), "login"));
		}
	}
}