/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import java.io.Serializable;

/**
 * @(#)ServiceTicket.java 1.0 14/09/2012
 *
 * ST的数据结构
 */
public class ServiceTicket implements Serializable {
	private String serviceNo;
	private String ticket;
	private String expireTime;

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
}
