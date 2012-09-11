package net.yoomai;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.wideplay.warp.persist.PersistenceService;
import net.yoomai.db.HibernateInitializer;
import net.yoomai.gate.AuthGate;
import net.yoomai.gate.STGate;

import javax.servlet.ServletContextEvent;

/**
 * @(#)YoomaiContext.java 1.0 11/09/2012
 * <p/>
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
public class YoomaiContext extends GuiceServletContextListener {
	private Injector persistInjector;

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				serve("/auth").with(AuthGate.class);
				serve("/st").with(STGate.class);
			}
		});
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		persistInjector = Guice.createInjector(PersistenceService.usingHibernate().buildModule());
	}
}
