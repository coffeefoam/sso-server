/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.gate;

import cn.com.opensource.net.NetUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @(#)AbstractGate.java 1.0 20/09/2012
 */
public class AbstractGate extends HttpServlet {
	Map makeParamMap(HttpServletRequest request) {
		Map params = new HashMap();
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String paramName = (String) enumeration.nextElement();
			String paramValue = NetUtil.getStringParameter(request, paramName, "");
			params.put(paramName, paramValue);
		}

		return params;
	}

	String makeParamURL(HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer();

		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String paramName = (String) enumeration.nextElement();
			if ("action".equals(paramName) || "password".equals(paramName)) {
				continue;
			}
			String paramValue = NetUtil.getStringParameter(request, paramName, "");
			buffer.append(paramName + "=" + paramValue + "&");
		}

		return buffer.toString();
	}
}
