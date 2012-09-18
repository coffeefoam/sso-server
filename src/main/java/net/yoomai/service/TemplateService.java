/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import net.yoomai.YoomaiContext;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * @(#)TemplateService.java 1.0 18/09/2012
 * <p/>
 * 负责模版渲染
 */
public class TemplateService {
	@Inject
	private VelocityEngine engine;
	@Inject @Named("encode")
	private String encoding;
	@Inject @Named("path")
	private String resourcePath;

	public TemplateService() {
	}

	public String paint(Map<String, Object> params, String templatePath) {
		init();
		VelocityContext context = new VelocityContext();
		if (params != null) {
			Iterator keys = params.keySet().iterator();
			while (keys.hasNext()) {
				Object key = keys.next();
				Object val = params.get(key);
				context.put(String.valueOf(key), val);
			}
		}
		StringWriter w = new StringWriter();

		try {
			Template template = engine.getTemplate(templatePath + ".vm");
			template.merge(context, w);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return w.toString();
	}


	private void init() {
		engine.setProperty(VelocityEngine.INPUT_ENCODING, encoding);
		engine.setProperty(VelocityEngine.OUTPUT_ENCODING, encoding);
		engine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, YoomaiContext.getApplicationPath() + "/" + resourcePath);
	}
}