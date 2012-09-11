package net.yoomai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import net.yoomai.gate.AuthGate;
import net.yoomai.gate.STGate;

/**
 * @(#)YoomaiContext.java 1.0 11/09/2012
 * <p/>
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
public class YoomaiContext extends GuiceServletContextListener {
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
}
