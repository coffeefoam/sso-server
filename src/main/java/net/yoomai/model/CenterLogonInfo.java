/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @(#)CenterLogonInfo.java 1.0 08/11/2012
 */
public class CenterLogonInfo implements Serializable {
 	private long id;
	private Long userId;
	private String ip;
	private Date inputDate;
	private Long companySid;
	private Integer logonType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Long getCompanySid() {
		return companySid;
	}

	public void setCompanySid(Long companySid) {
		this.companySid = companySid;
	}

	public Integer getLogonType() {
		return logonType;
	}

	public void setLogonType(Integer logonType) {
		this.logonType = logonType;
	}
}
