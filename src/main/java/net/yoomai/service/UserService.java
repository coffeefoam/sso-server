/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.db.UserDAO;
import net.yoomai.model.User;

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
	 * @param uid
	 * @param password
	 * @return
	 */
	public User auth(long uid, String password) {
		User user = udao.find(uid, password);

		return user;
	}

	/**
	 * 根据某个uid获取用户相关信息，全部的信息
	 * @param uid
	 * @return
	 */
	public User find(long uid) {
		User user = udao.find(uid);

		return user;
	}
}
