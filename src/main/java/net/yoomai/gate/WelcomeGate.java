/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.yoomai.service.TemplateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @(#)WelcomeGate.java 1.0 18/09/2012
 */
@Singleton
public class WelcomeGate extends HttpServlet {
	@Inject
	private TemplateService templateService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(templateService.paint(null, "welcome"));
		response.getWriter().close();
	}
}
