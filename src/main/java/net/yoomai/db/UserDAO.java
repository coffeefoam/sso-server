/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.Transactional;
import com.wideplay.warp.persist.dao.Finder;
import net.yoomai.model.User;

import java.util.List;

/**
 * @(#)UserDAO.java 1.0 13/09/2012
 */
public class UserDAO extends BaseDAO<User, Long> {
	public UserDAO() {
		super(User.class);
	}

	@Transactional
	@Finder(query="from User where uid=:uid and password=:password")
	public User find(@Named("uid") long uid, @Named("password") String password) {
		throw new AssertionError();
	}

	@Transactional
	@Finder(query="from User where uid=:uid")
	public User find(@Named("uid") long uid) {
		return null;
	}

	@Transactional
	@Finder(query = "from User")
	public List findAllUsers() {
		throw new AssertionError();
	}
}
