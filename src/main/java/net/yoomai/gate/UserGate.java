/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.sf.json.JSONObject;
import net.yoomai.model.User;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;
import org.apache.log4j.Logger;

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
	private Logger log = Logger.getLogger(UserGate.class);

	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");

		String st = NetUtil.getStringParameter(request, "st", "");
		String[] items = ticketService.getItems(st);

		String result = "";

		if (items == null) {
			result = "";
		} else {
			User user = service.find(Long.parseLong(items[2]));
			log.debug("net broker:" + user.getNetBroker());
			result = JSONObject.fromObject(user).toString();
		}

		Writer writer = response.getWriter();
		writer.write(result);
	}
}
