/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.config;

import com.google.inject.Inject;
import com.wideplay.warp.persist.PersistenceService;

/**
 * @(#)InitializerHibernate.java 1.0 17/09/2012
 */
public class InitializerHibernate {
	private final PersistenceService service;

	@Inject
	InitializerHibernate(PersistenceService service) {
		this.service = service;
		service.start();

		System.out.println("----------InitializerHibernate start---------");
	}
}
