/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @(#)STGate.java 1.0 11/09/2012
 *
 * 这是获取服务Tickit的目标地址。当客户端请求被转向到此地址，该服务将对客户端的TGT进行验证，
 * 若通过，则进行ST的下发，若没通过，则进行转向，进行登录授权。
 */
@Singleton
public class STGate extends HttpServlet {
	@Inject
	private TicketService service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
