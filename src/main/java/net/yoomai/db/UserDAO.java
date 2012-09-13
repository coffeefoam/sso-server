/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import net.yoomai.model.User;

/**
 * @(#)UserDAO.java 1.0 13/09/2012
 */
public class UserDAO extends BaseDAO<User, Long> {
	public UserDAO() {
		super(User.class);
	}
}
