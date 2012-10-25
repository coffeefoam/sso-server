package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.service.TemplateService;
import net.yoomai.service.TicketService;
import net.yoomai.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @(#)AuthGate.java 1.0 11/09/2012
 * <p/>
 * ����һ���û���Ϣ��֤�����
 * ���û����ͻ����ض��������ַ��ʱ����Ҫ��cookie���м�⣬���Ƿ����һ����ص�TGTƱ����Ϣ
 * ��������ڣ�����е�¼��֤��������ڣ���������ST��������
 * <p/>
 * <p/>
 * �û�����ĵ�ַ�� s=A&back=url
 * �ض�����û��ĵ�ַ�� s=A&st=1q2w3e4r
 */
@Singleton
public class AuthGate extends AbstractGate {
	@Inject
	private UserService service;
	@Inject
	private TicketService ticketService;
	@Inject
	private TemplateService templateService;

	/* log configuration */
	private Logger log = Logger.getLogger(AuthGate.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * �ش����������� app��service
		 * app����ssoע���������������ı��
		 * service�Ǹ���������Ҫ���з�����֤�ķ������
		 * service ticket�Ǹ���app��service�Լ�һ��ʱ���������
		 */
		String appId = NetUtil.getStringParameter(request, "app", "");
		String service = NetUtil.getStringParameter(request, "service", "");
		// back�ǿͻ���Ҫ����֤����֮�������ת�ĵ�ַ��Ĭ����sso���������welcomeҳ��
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
				// ������Ӧ��ST��Ȼ����ת
				log.debug("TGT be found [" + ticket + "]");
				log.debug("After TGT found, we will generate new service ticket for you, baby.");
				st = ticketService.generateST(appId, service);
			} else {
				log.debug("Sorry, baby. we can't find TGT. Now, you should redirect login page.");
				redirect = "/login";
			}
		} else {
			log.debug("Fuck, you are not login.");
			redirect = "/login";
		}

		String p = makeParamURL(request);

		log.debug("All right, auth end. service tikect is [" + st + "]");
		response.sendRedirect(redirect + "?" + p + "st=" + st);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = NetUtil.getStringParameter(request, "app", "");
		String service = NetUtil.getStringParameter(request, "service", "");
		// �����ڽ��е�Ե���֤������£��Ż����service ticket�Ľ��գ����������ǽ���st����֤
		// ����֤�ɹ��󣬻᷵���µ�st������û�ɹ�����᷵�ؿմ�
		String ticket = URLEncoder.encode(NetUtil.getStringParameter(request, "st", ""), "UTF-8");

		log.debug("I will verify service ticket.");
		String token = ticketService.verifyST(app, service, ticket);
		Map results = new HashMap();
		if (token == null) {
			results.put("verify", "false");
		} else {
			results.put("verify", "true");
		}

		results.put("st", token);

		response.getWriter().write(templateService.paint(results, "ticket"));
	}
}