/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.YoomaiContext;
import net.yoomai.config.GlobalConfig;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * @(#)TemplateService.java 1.0 18/09/2012
 * <p/>
 * ¸ºÔðÄ£°æäÖÈ¾
 */
public class TemplateService {
	@Inject
	private VelocityEngine engine;

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

	public void init() {
		engine.setProperty(VelocityEngine.INPUT_ENCODING, GlobalConfig.get("encode"));
		engine.setProperty(VelocityEngine.OUTPUT_ENCODING, GlobalConfig.get("encode"));
		engine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, YoomaiContext.getApplicationPath() + "/" + GlobalConfig.get("template.path"));
	}
}
