/*
 * @(#)User.java 1.0 12/09/2012
 *
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ray
 * @version 1.0, 12/09/2012
 * @since 1.5
 */
public class User implements Serializable, Cloneable {
	private static final long serialVersionUID = 9041423500127665564L;

	private long uid;
	private String password;

	@Transient
	private String lastIp;
	@Transient
	private Date lastTime;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
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
