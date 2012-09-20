package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @(#)AuthGate.java 1.0 11/09/2012
 * <p/>
 * 这是一个用户信息验证的入口
 * 当用户被客户端重定向到这个地址的时候，需要对cookie进行检测，看是否存在一个相关的TGT票据信息
 * 如果不存在，则进行登录验证；如果存在，则对请求的ST进行生成
 *
 * <p/>
 * 用户请求的地址是 s=A&back=url
 * 重定向给用户的地址是 s=A&st=1q2w3e4r
 */
@Singleton
public class AuthGate extends AbstractGate {
	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 必传的两个参数 app和service
		 * app是在sso注册过的域名所分配的编号
		 * service是该域名下面要进行服务认证的服务代码
		 * service ticket是根据app和service以及一个时间戳来生成
		 */
   	    String appId = NetUtil.getStringParameter(request, "app", "");
		String service = NetUtil.getStringParameter(request, "service", "");
		// back是客户端要在认证做完之后进行跳转的地址，默认是sso域名下面的welcome页面
		String back = NetUtil.getStringParameter(request, "back", "/welcome");

		String redirect = back;

		if ("".equals(appId) || appId == null) {
			response.sendRedirect(back);
			return;
		}

		String st = "";
		String _uid = ticketService.verifyTGT(request.getCookies());

		if (_uid != null) {
			String ticket = ticketService.verifyTGT(_uid);

			if (ticket != null) {
				// 分配相应的ST，然后跳转
				st = ticketService.generateST(appId, service);
			} else {
				redirect = "/login";
			}
		} else {
			redirect = "/login";
		}

		String p = makeParamURL(request);

		response.sendRedirect(redirect + "?" + p + "st=" + st);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    String app = NetUtil.getStringParameter(request, "app", "");
		String service = NetUtil.getStringParameter(request, "service", "");
		// 这是在进行点对点验证的情况下，才会进行service ticket的接收，接下来就是进行st的验证
		// 当验证成功后，会返回新的st串；若没成功，则会返回空串
		String ticket = URLEncoder.encode(NetUtil.getStringParameter(request, "st", ""), "UTF-8");

		String token = ticketService.verifyST(app, service, ticket);
		response.getWriter().write(token);
	}
}
