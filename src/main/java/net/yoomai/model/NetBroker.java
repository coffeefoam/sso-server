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

	private Long id;
	private Long userid;
	private Long creater;
	private Date createtime;
	private String name;
	private Long isindex;
	private Long score;
	private Long areaid;
	private String imgpath;
	private Long companysid;
	private Long blogtheme;
	private String msn;
	private Long isimg;
	private Long brokertype;
	private Long renthousenum;
	private Long exchangehousenum;
	private String taobao;
	private String sinaweibo;
	private String fetion;
	private String bbsuser;
	private String bbspassword;
	private Long bestareaid;
	private Long bestdistrict;
	private String maxim;
	private String callboard;
	private Long jobspecialsingle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
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

	public Long getIsindex() {
		return isindex;
	}

	public void setIsindex(Long isindex) {
		this.isindex = isindex;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Long getCompanysid() {
		return companysid;
	}

	public void setCompanysid(Long companysid) {
		this.companysid = companysid;
	}

	public Long getBlogtheme() {
		return blogtheme;
	}

	public void setBlogtheme(Long blogtheme) {
		this.blogtheme = blogtheme;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public Long getIsimg() {
		return isimg;
	}

	public void setIsimg(Long isimg) {
		this.isimg = isimg;
	}

	public Long getBrokertype() {
		return brokertype;
	}

	public void setBrokertype(Long brokertype) {
		this.brokertype = brokertype;
	}

	public Long getRenthousenum() {
		return renthousenum;
	}

	public void setRenthousenum(Long renthousenum) {
		this.renthousenum = renthousenum;
	}

	public Long getExchangehousenum() {
		return exchangehousenum;
	}

	public void setExchangehousenum(Long exchangehousenum) {
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

	public Long getBestareaid() {
		return bestareaid;
	}

	public void setBestareaid(Long bestareaid) {
		this.bestareaid = bestareaid;
	}

	public Long getBestdistrict() {
		return bestdistrict;
	}

	public void setBestdistrict(Long bestdistrict) {
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

	public Long getJobspecialsingle() {
		return jobspecialsingle;
	}

	public void setJobspecialsingle(Long jobspecialsingle) {
		this.jobspecialsingle = jobspecialsingle;
	}
}
