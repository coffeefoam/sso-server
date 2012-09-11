/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.Inject;
import com.wideplay.warp.persist.PersistenceService;

/**
 * @(#)HibernateInitializer.java 1.0 11/09/2012
 */
public class HibernateInitializer {
	private final PersistenceService service;

	@Inject
	public HibernateInitializer(PersistenceService service) {
		this.service = service;

		service.start();
	}
}
