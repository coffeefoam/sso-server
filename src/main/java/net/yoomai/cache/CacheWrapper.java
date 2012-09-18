/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.cache;

/**
 * @(#)CacheWrapper.java 1.0 18/09/2012
 */
public interface CacheWrapper<K, V> {
	void put(K key, V value);

	V get(K key);

	void remove(K key);
}
