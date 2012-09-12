/*
 * @(#)User.java 1.0 12/09/2012
 *
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ray
 * @version 1.0, 12/09/2012
 * @since 1.5
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private long uid;
	private String name;
	private String password;
	private String lastIp;
	private Date lastTime;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
