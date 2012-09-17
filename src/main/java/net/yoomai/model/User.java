/*
 * @(#)User.java 1.0 12/09/2012
 *
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ray
 * @version 1.0, 12/09/2012
 * @since 1.5
 */
public class User implements Serializable {
	private long uid;
	private String username;
	private String password;
	private String lastIp;
	private Date lastTime;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
}
