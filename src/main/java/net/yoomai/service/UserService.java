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
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @(#)UserService.java 1.0 13/09/2012
 */
public class UserService {
	private UserDAO udao;
	private CenterLogonInfoDAO logonDao;

	private Logger log = Logger.getLogger(UserService.class);

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
	public User auth(long uid, String password, String ip) {
		User user = udao.find(uid, password);

		CenterLogonInfo logonInfo = logonDao.getLogonInfo(uid, 1, 1);

		log.debug("center logon info: " + logonInfo);
		log.debug("user: " + user);

		// �ж����ε�¼����Ƿ�С��ϵͳ�涨��ʱ��
		if (logonInfo != null && user != null) {
			long intertime = new Date().getTime() - logonInfo.getInputDate().getTime();
			long time = Long.parseLong(GlobalConfig.get("time"));

			log.debug("input date: " + logonInfo.getInputDate());
			log.debug("time: " + time);
			// ���뼶
			if (intertime > time*1000) {
			    long id = logonDao.getSeq();
				CenterLogonInfo info = new CenterLogonInfo();
				info.setId(id);
				info.setUserId(uid);
				info.setIp(ip);
				info.setInputDate(new Date());
				info.setCompanySid(user.getCompanysid());
				info.setLogonType(1);
				logonDao.save(info);
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
