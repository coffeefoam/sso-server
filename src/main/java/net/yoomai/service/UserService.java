/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.db.UserDAO;

/**
 * @(#)UserService.java 1.0 13/09/2012
 */
public class UserService {
	private UserDAO udao;

	@Inject
	public UserService(UserDAO udao) {
		this.udao = udao;
	}

	/**
	 * 用户的验证方法。
	 *
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean auth(String name, String password) {
		return true;
	}
}
