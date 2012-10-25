/*
 * @(#)User.java 1.0 12/09/2012
 *
 * Copyright (c) 2011, yoomai.cn. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author ray
 * @version 1.0, 12/09/2012
 * @since 1.5
 */
public class User implements Serializable {
	private static final long serialVersionUID = 9041423500127665564L;

	private Long uid;
	private Long companysid;
	private Long rolesid;
	private Long headerId;
	private String username;
	private String usertel;
	private String useridcord;
	private String password;
	private Integer sex;
	private Date birthday;
	private String usertitle;
	private String hometel;
	private String bp;
	private String handset;
	private String address;
	private String elseinfo;
	private Long departmentsid;
	private String vestdept;
	private Long residentshopid;
	private Long employeeid;
	private Long status;
	private String loginname;
	private String rolescope;
	private Integer team;
	private String useremail;
	private String comemail;
	private Integer cellview;
	private String enterdate;
	private String leavedate;
	private Integer iswebbroker;
	private String brokercard;
	private Integer registcoderole;
	private Long viewsum;
	private String msnid;
	private String qqid;
	private Long wbrokerleaderid;
	private Long iswbrokerleader;
	private Long physicalshopid;
	private String phs;
	private String bpbak;
	private String bpbakid;
	private Long certificate;
	private Long is5i5jwebuser;
	private String copyrolescope;
	private Long presentstate;
	private String mobileerp;
	private Long mobileerpid;

	@Transient
	private String lastIp;
	@Transient
	private Date lastTime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getCompanysid() {
		return companysid;
	}

	public void setCompanysid(Long companysid) {
		this.companysid = companysid;
	}

	public Long getRolesid() {
		return rolesid;
	}

	public void setRolesid(Long rolesid) {
		this.rolesid = rolesid;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getUseridcord() {
		return useridcord;
	}

	public void setUseridcord(String useridcord) {
		this.useridcord = useridcord;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsertitle() {
		return usertitle;
	}

	public void setUsertitle(String usertitle) {
		this.usertitle = usertitle;
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getHandset() {
		return handset;
	}

	public void setHandset(String handset) {
		this.handset = handset;
	}

	public String getAddress() throws UnsupportedEncodingException {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getElseinfo() {
		return elseinfo;
	}

	public void setElseinfo(String elseinfo) {
		this.elseinfo = elseinfo;
	}

	public Long getDepartmentsid() {
		return departmentsid;
	}

	public void setDepartmentsid(Long departmentsid) {
		this.departmentsid = departmentsid;
	}

	public String getVestdept() {
		return vestdept;
	}

	public void setVestdept(String vestdept) {
		this.vestdept = vestdept;
	}

	public Long getResidentshopid() {
		return residentshopid;
	}

	public void setResidentshopid(Long residentshopid) {
		this.residentshopid = residentshopid;
	}

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getRolescope() {
		return rolescope;
	}

	public void setRolescope(String rolescope) {
		this.rolescope = rolescope;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getComemail() {
		return comemail;
	}

	public void setComemail(String comemail) {
		this.comemail = comemail;
	}

	public Integer getCellview() {
		return cellview;
	}

	public void setCellview(Integer cellview) {
		this.cellview = cellview;
	}

	public String getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}

	public String getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(String leavedate) {
		this.leavedate = leavedate;
	}

	public Integer getIswebbroker() {
		return iswebbroker;
	}

	public void setIswebbroker(Integer iswebbroker) {
		this.iswebbroker = iswebbroker;
	}

	public String getBrokercard() {
		return brokercard;
	}

	public void setBrokercard(String brokercard) {
		this.brokercard = brokercard;
	}

	public Integer getRegistcoderole() {
		return registcoderole;
	}

	public void setRegistcoderole(Integer registcoderole) {
		this.registcoderole = registcoderole;
	}

	public Long getViewsum() {
		return viewsum;
	}

	public void setViewsum(Long viewsum) {
		this.viewsum = viewsum;
	}

	public String getMsnid() {
		return msnid;
	}

	public void setMsnid(String msnid) {
		this.msnid = msnid;
	}

	public String getQqid() {
		return qqid;
	}

	public void setQqid(String qqid) {
		this.qqid = qqid;
	}

	public Long getWbrokerleaderid() {
		return wbrokerleaderid;
	}

	public void setWbrokerleaderid(Long wbrokerleaderid) {
		this.wbrokerleaderid = wbrokerleaderid;
	}

	public Long getIswbrokerleader() {
		return iswbrokerleader;
	}

	public void setIswbrokerleader(Long iswbrokerleader) {
		this.iswbrokerleader = iswbrokerleader;
	}

	public Long getPhysicalshopid() {
		return physicalshopid;
	}

	public void setPhysicalshopid(Long physicalshopid) {
		this.physicalshopid = physicalshopid;
	}

	public String getPhs() {
		return phs;
	}

	public void setPhs(String phs) {
		this.phs = phs;
	}

	public String getBpbak() {
		return bpbak;
	}

	public void setBpbak(String bpbak) {
		this.bpbak = bpbak;
	}

	public String getBpbakid() {
		return bpbakid;
	}

	public void setBpbakid(String bpbakid) {
		this.bpbakid = bpbakid;
	}

	public Long getCertificate() {
		return certificate;
	}

	public void setCertificate(Long certificate) {
		this.certificate = certificate;
	}

	public Long getIs5i5jwebuser() {
		return is5i5jwebuser;
	}

	public void setIs5i5jwebuser(Long is5i5jwebuser) {
		this.is5i5jwebuser = is5i5jwebuser;
	}

	public String getCopyrolescope() {
		return copyrolescope;
	}

	public void setCopyrolescope(String copyrolescope) {
		this.copyrolescope = copyrolescope;
	}

	public Long getPresentstate() {
		return presentstate;
	}

	public void setPresentstate(Long presentstate) {
		this.presentstate = presentstate;
	}

	public String getMobileerp() {
		return mobileerp;
	}

	public void setMobileerp(String mobileerp) {
		this.mobileerp = mobileerp;
	}

	public Long getMobileerpid() {
		return mobileerpid;
	}

	public void setMobileerpid(Long mobileerpid) {
		this.mobileerpid = mobileerpid;
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
