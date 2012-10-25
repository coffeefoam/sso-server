package net.yoomai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;
import net.yoomai.gate.AuthGate;
import net.yoomai.gate.LoginGate;
import net.yoomai.gate.UserGate;
import net.yoomai.gate.WelcomeGate;
import net.yoomai.module.CacheModule;
import net.yoomai.module.DBModule;
import net.yoomai.module.TemplateModule;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;

/**
 * @(#)YoomaiContext.java 1.0 11/09/2012
 * <p/>
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
public class YoomaiContext extends GuiceServletContextListener {
	private static String path;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		path = event.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(path + "WEB-INF/classes/log4j.properties");
	}

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
			new DBModule(),
			new CacheModule(),
			new TemplateModule(),
			PersistenceService.usingHibernate().across(UnitOfWork.REQUEST).buildModule(),
			new ServletModule() {
				@Override
				protected void configureServlets() {
					serve("/auth").with(AuthGate.class);
					serve("/login").with(LoginGate.class);
					serve("/welcome").with(WelcomeGate.class);
					serve("/user").with(UserGate.class);
				}
			}
		);
	}

	public static String getApplicationPath() {
		return path;
	}
}
