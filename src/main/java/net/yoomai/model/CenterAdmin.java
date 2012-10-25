/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @(#)CenterAdmin.java 1.0 25/10/2012
 */
public class CenterAdmin implements Serializable {
	private static final long serialVersionUID = 7949233282846961093L;

	private long userid;
	private long type;
	private Date inputDate;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
}
