/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.service;

import com.google.inject.Inject;
import net.yoomai.config.GlobalConfig;
import net.yoomai.db.CenterLogonInfoDAO;
import net.yoomai.db.UserDAO;
import net.yoomai.model.CenterLogonInfo;
import net.yoomai.model.User;

import java.util.Date;

/**
 * @(#)UserService.java 1.0 13/09/2012
 */
public class UserService {
	private UserDAO udao;
	private CenterLogonInfoDAO logonDao;

	@Inject
	public UserService(UserDAO udao, CenterLogonInfoDAO logonDao) {
		this.udao = udao;
		this.logonDao = logonDao;
	}

	/**
	 * �û�����֤������
	 *
	 * @param uid
	 * @param password
	 * @return
	 */
	public User auth(long uid, String password) {
		User user = udao.find(uid, password);

		CenterLogonInfo logonInfo = logonDao.getLogonInfo(uid, 1, 1);
		if (logonInfo != null) {
			long intertime = new Date().getTime() - logonInfo.getInputDate().getTime();
			long time = Long.parseLong(GlobalConfig.get("time"));
			// ���뼶
			if (intertime < time*1000) {

			}
		}

		return user;
	}

	/**
	 * ����ĳ��uid��ȡ�û������Ϣ��ȫ������Ϣ
	 * @param uid
	 * @return
	 */
	public User find(long uid) {
		User user = udao.find(uid);

		return user;
	}
}
