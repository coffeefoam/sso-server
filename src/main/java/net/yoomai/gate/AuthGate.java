package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
public class AuthGate extends HttpServlet {
	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    String appId = NetUtil.getStringParameter(request, "appId", "");
		String back = NetUtil.getStringParameter(request, "back", "/welcome");
		String redirect = "/login";

		if ("".equals(service) || service == null) {
			response.sendRedirect(back);
		}

		Map params = new HashMap();
		params.put("appId", appId);
		params.put("back", back);

		String _tgt_id = ticketService.verifyTGT(request.getCookies());
		if (_tgt_id != null) {
			String ticket = ticketService.verifyTGT(_tgt_id);
			if (ticket != null) {
				// 分配相应的ST，然后跳转
				String st = ticketService.generateST(appId, ticket);
				params.put("st", st);
			}
		}

		String p = makeRedirectParams(params);
		response.sendRedirect(redirect + "?" + p);
	}

	private String makeRedirectParams(Map<String, String> params) {
		StringBuffer buffer = new StringBuffer();

		Iterator keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = params.get(key);

			buffer.append(key + "=" + value);
			buffer.append("&");
		}

		return buffer.toString();
	}
}
