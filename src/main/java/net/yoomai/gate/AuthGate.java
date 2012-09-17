package net.yoomai.gate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.model.User;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @(#)AuthGate.java 1.0 11/09/2012
 * <p/>
 * 这是一个用户信息验证的入口
 * 当用户被客户端重定向到这个地址的时候，需要对cookie进行检测，看是否存在一个相关的TGT票据信息
 * 如果不存在，则进行登录验证；如果存在，则对请求的ST进行生成
 */
@Singleton
public class AuthGate extends HttpServlet {
	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = service.auth("yulei", "yulei");
		String _tgt_id = ticketService.generateTGT(request.getCookies(), user);

		Cookie cookie = new Cookie("_id_", _tgt_id);
		response.addCookie(cookie);
		response.getWriter().write("<html><body>");
		response.getWriter().write("<a href='/st?service=A&st='>ST</a>");
		response.getWriter().write("</body></html>");

	}
}
