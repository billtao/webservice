package com.sinosoft.ie.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:auth.properties")
public class AuthConfig {
	private String username;
	private String password;
	private String servicetype;
	private String biztype;
	private String orgcode;
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
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getBiztype() {
		return biztype;
	}
	public void setBiztype(String biztype) {
		this.biztype = biztype;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	
}
