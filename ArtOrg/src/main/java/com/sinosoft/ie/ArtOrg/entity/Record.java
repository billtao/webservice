package com.sinosoft.ie.ArtOrg.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ctc.wstx.util.StringUtil;
import com.sinosoft.ie.config.AuthConfig;
@Component
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Record implements Serializable{
	
	
	@Autowired
	private AuthConfig authConfig;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String sendtime ;//调度频率
	//private String title ;// 
	private String username ;// 
	
	private String password ;// 
	private String servicetype ;// 
	private String biztype ;// 
	private String orgcode ;// 
	private String count ;//行数
	@XmlElementWrapper(name="orglist") 
    @XmlElement(name="orginfo") 
	private List<OrgInfo> orglist ;//数据集合
	public String getSendtime() {
		return sendtime;
	}

	@Override
	public String toString() {
		return "Record [sendtime=" + sendtime + ", username=" + username + ", password=" + password
				+ ", servicetype=" + servicetype + ", biztype=" + biztype + ", orgcode=" + orgcode + ", count=" + count
				+ ", orglist=" + orglist + "]";
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public Record(String sendtime, String username, String password, String servicetype, String biztype,
			String orgcode, String count, List<OrgInfo> orglist) {
		super();
		this.sendtime = sendtime;
		this.username = username;
		this.password = password;
		this.servicetype = servicetype;
		this.biztype = biztype;
		this.orgcode = orgcode;
		this.count = count;
		this.orglist = orglist;
	}

	public String getUsername() {
		//System.out.println(authConfig.getUsername()+"11111111111111111111");
		return StringUtils.isEmpty(username)?authConfig.getUsername():username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return StringUtils.isEmpty(password)?authConfig.getPassword():password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServicetype() {
		return StringUtils.isEmpty(servicetype)?authConfig.getServicetype():servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getBiztype() {
		return StringUtils.isEmpty(biztype)?authConfig.getBiztype():biztype;
	}

	public void setBiztype(String biztype) {
		this.biztype = biztype;
	}

	public String getOrgcode() {
		return StringUtils.isEmpty(orgcode)?authConfig.getOrgcode():orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	public List<OrgInfo> getOrglist() {
		return orglist;
	}

	public void setOrglist(List<OrgInfo> orglist) {
		this.orglist = orglist;
	}

	
	
	public Record() {
		super();
	}

	 
	
}
