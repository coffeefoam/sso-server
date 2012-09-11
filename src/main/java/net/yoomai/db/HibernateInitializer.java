/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.Inject;
import com.wideplay.warp.persist.PersistenceService;

/**
 * @(#)HibernateInitializer.java 1.0 11/09/2012
 *
 * Hibernate模块的初始化，需要在系统启动的时候，就将此模块进行加载，便于后续程序使用
 */
public class HibernateInitializer {
	private final PersistenceService service;

	@Inject
	public HibernateInitializer(PersistenceService service) {
		this.service = service;

		service.start();
	}
}
