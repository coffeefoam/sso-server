/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.cache;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.yoomai.module.annotation.CM;

/**
 * @(#)EhcacheWrapper.java 1.0 18/09/2012
 */
public class EhcacheWrapper<K, V> implements CacheWrapper<K, V> {
	@Inject @Named("cachename")
	private String cacheName;
	@Inject @CM
	private CacheManager cacheManager;

	public EhcacheWrapper() {

	}

	public void put(final K key, final V value) {
		getCache().put(new Element(key, value));
	}

	public void remove(final K key) {
		getCache().remove(key);
	}

	public V get(final K key) {
		Element element = getCache().get(key);

		if (element != null) {
			return (V) element.getValue();
		}
		return null;
	}

	public Ehcache getCache() {
		return cacheManager.getEhcache(cacheName);
	}
}

