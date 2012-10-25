/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @(#)NetBroker.java 1.0 25/10/2012
 */
public class NetBroker implements Serializable {
	private static final long serialVersionUID = -4384143947658468396L;

	private long id;
	private long userid;
	private long creater;
	private Date createtime;
	private String name;
	private long isindex;
	private long score;
	private long areaid;
	private String imgpath;
	private long companysid;
	private long blogtheme;
	private String msn;
	private long isimg;
	private long brokertype;
	private long renthousenum;
	private long exchangehousenum;
	private String taobao;
	private String sinaweibo;
	private String fetion;
	private String bbsuser;
	private String bbspassword;
	private long bestareaid;
	private long bestdistrict;
	private String maxim;
	private String callboard;
	private long jobspecialsingle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getCreater() {
		return creater;
	}

	public void setCreater(long creater) {
		this.creater = creater;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIsindex() {
		return isindex;
	}

	public void setIsindex(long isindex) {
		this.isindex = isindex;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getAreaid() {
		return areaid;
	}

	public void setAreaid(long areaid) {
		this.areaid = areaid;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public long getCompanysid() {
		return companysid;
	}

	public void setCompanysid(long companysid) {
		this.companysid = companysid;
	}

	public long getBlogtheme() {
		return blogtheme;
	}

	public void setBlogtheme(long blogtheme) {
		this.blogtheme = blogtheme;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public long getIsimg() {
		return isimg;
	}

	public void setIsimg(long isimg) {
		this.isimg = isimg;
	}

	public long getBrokertype() {
		return brokertype;
	}

	public void setBrokertype(long brokertype) {
		this.brokertype = brokertype;
	}

	public long getRenthousenum() {
		return renthousenum;
	}

	public void setRenthousenum(long renthousenum) {
		this.renthousenum = renthousenum;
	}

	public long getExchangehousenum() {
		return exchangehousenum;
	}

	public void setExchangehousenum(long exchangehousenum) {
		this.exchangehousenum = exchangehousenum;
	}

	public String getTaobao() {
		return taobao;
	}

	public void setTaobao(String taobao) {
		this.taobao = taobao;
	}

	public String getSinaweibo() {
		return sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}

	public String getFetion() {
		return fetion;
	}

	public void setFetion(String fetion) {
		this.fetion = fetion;
	}

	public String getBbsuser() {
		return bbsuser;
	}

	public void setBbsuser(String bbsuser) {
		this.bbsuser = bbsuser;
	}

	public String getBbspassword() {
		return bbspassword;
	}

	public void setBbspassword(String bbspassword) {
		this.bbspassword = bbspassword;
	}

	public long getBestareaid() {
		return bestareaid;
	}

	public void setBestareaid(long bestareaid) {
		this.bestareaid = bestareaid;
	}

	public long getBestdistrict() {
		return bestdistrict;
	}

	public void setBestdistrict(long bestdistrict) {
		this.bestdistrict = bestdistrict;
	}

	public String getMaxim() {
		return maxim;
	}

	public void setMaxim(String maxim) {
		this.maxim = maxim;
	}

	public String getCallboard() {
		return callboard;
	}

	public void setCallboard(String callboard) {
		this.callboard = callboard;
	}

	public long getJobspecialsingle() {
		return jobspecialsingle;
	}

	public void setJobspecialsingle(long jobspecialsingle) {
		this.jobspecialsingle = jobspecialsingle;
	}
}
