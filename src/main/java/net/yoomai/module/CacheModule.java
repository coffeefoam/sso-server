/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import net.sf.ehcache.CacheManager;
import net.yoomai.cache.CacheWrapper;
import net.yoomai.cache.EhcacheWrapper;

/**
 * @(#)CacheModule.java 1.0 18/09/2012
 */
public class CacheModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("cachename")).toInstance("sso-cache");
		bind(CacheWrapper.class).to(EhcacheWrapper.class);
	}

	@Provides @CM
	CacheManager provideCacheManage() {
		return CacheManager.create();
	}
}
