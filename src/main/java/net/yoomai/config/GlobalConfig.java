/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @(#)GlobalConfig.java 1.0 13/09/2012
 * </p>
 * ȫ���������ļ��ļ��������á�
 */
public class GlobalConfig {
  	private static PropertiesConfiguration configuration;

	static {
		try {
			configuration = new PropertiesConfiguration("global.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return configuration.getString(key);
	}
}
