/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @(#)AuthFilter.java 1.0 26/10/2012
 */
public class AuthFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;


	}

	public void destroy() {

	}
}
