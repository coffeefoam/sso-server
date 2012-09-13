/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.config;

import com.google.inject.name.Named;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @(#)GlobalConfig.java 1.0 13/09/2012
 * </p>
 * 全局性配置文件的加载与设置。
 */
public class GlobalConfig {
  	private PropertiesConfiguration configuration;

	public GlobalConfig(@Named("properties.name") String propName) {
		try {
			configuration = new PropertiesConfiguration(propName);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
}
