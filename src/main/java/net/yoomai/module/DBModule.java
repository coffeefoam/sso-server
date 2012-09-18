/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.module;

import com.google.inject.AbstractModule;
import net.yoomai.config.GlobalConfig;
import net.yoomai.config.InitializerHibernate;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @(#)DBModule.java 1.0 11/09/2012
 */
public class DBModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Configuration.class).toInstance(new AnnotationConfiguration().addResource(GlobalConfig.get("model")));

		bind(InitializerHibernate.class).asEagerSingleton();
	}
}
