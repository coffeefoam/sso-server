/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @(#)BaseDAO.java 1.0 13/09/2012
 */
public class BaseDAO<T, PK extends Serializable> {
	@Inject
	protected Provider<Session> session;

	private Class<T> persistClass;

	public BaseDAO(Class<T> persistClass) {
		this.persistClass = persistClass;
	}

	public T find(PK id) {
		return (T) session.get().get(persistClass, id);
	}

	public List<T> findAll() {
		return session.get().createQuery("from " + this.persistClass.getSimpleName()).list();
	}

	public void save(T object) {
		session.get().save(object);
	}

	public void remove(PK id) {
		Object obj = session.get().get(persistClass, id);
		if (obj != null) {
			session.get().delete(obj);
		}
	}
}
