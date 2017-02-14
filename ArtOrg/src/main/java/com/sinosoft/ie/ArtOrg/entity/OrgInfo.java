package com.sinosoft.ie.ArtOrg.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.stereotype.Component;

import com.sinosoft.ie.utils.JavaXmlAdapter;

@XmlRootElement(name="orginfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrgInfo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id ;//技术表主键，所查数据的唯一性标识
	private String area_code ;//行政区划代码
	private String area ;//行政区划
	private String ocode  ;//组织机构代码
	private String institution_name ;//机构名称
	private String corporate  ;//法定代表人
	private String corporate_regnumber ;//法人登记号
	private String tech_type ;//准入技术
	private String health_license ;//许可证登记号
	private String approve_date ;//批准时间
	private String run_status ;//运行状态
	private String charge_in_person ;//精子库负责人
 

	public OrgInfo() {
		super();
	}

	public OrgInfo(String id, String area_code, String area, String ocode, String institution_name, String corporate,
			String corporate_regnumber, String tech_type, String health_license, String approve_date, String run_status,
			String charge_in_person) {
		super();
		this.id  = id ;
		this.area_code = area_code;
		this.area = area;
		this.ocode  = ocode ;
		this.institution_name = institution_name;
		this.corporate  = corporate ;
		this.corporate_regnumber = corporate_regnumber;
		this.tech_type = tech_type;
		this.health_license = health_license;
		this.approve_date = approve_date;
		this.run_status  = run_status ;
		this.charge_in_person = charge_in_person;
	}

	public String getId() {
		return id ;
	}

	public void setId(String id ) {
		this.id  = id ;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOcode() {
		return ocode ;
	}

	public void setOcode(String ocode ) {
		this.ocode  = ocode ;
	}

	public String getInstitution_name() {
		return institution_name;
	}

	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}

	public String getCorporate() {
		return corporate ;
	}

	public void setCorporate(String corporate ) {
		this.corporate  = corporate ;
	}

	public String getCorporate_regnumber() {
		return corporate_regnumber;
	}

	public void setCorporate_regnumber(String corporate_regnumber) {
		this.corporate_regnumber = corporate_regnumber;
	}

	public String getTech_type() {
		return tech_type;
	}

	public void setTech_type(String tech_type) {
		this.tech_type = tech_type;
	}

	public String getLicense() {
		return health_license;
	}

	public void setHealth_license(String health_license) {
		this.health_license = health_license;
	}

	public String getApprove_date() {
		return approve_date;
	}

	public void setApprove_date(String approve_date) {
		this.approve_date = approve_date;
	}

	public String getRun_status() {
		return run_status ;
	}

	public void setRun_status(String run_status ) {
		this.run_status  = run_status ;
	}

	
	public String getCharge_in_person() {
		return charge_in_person==null?"":charge_in_person;
	}

	public void setCharge_in_person(String charge_in_person) {
		this.charge_in_person = charge_in_person;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrgInfo [id=" + id + ", area_code=" + area_code + ", area=" + area + ", ocode =" + ocode 
				+ ", institution_name=" + institution_name + ", corporate =" + corporate  + ", corporate_regnumber=" + corporate_regnumber
				+ ", tech_type=" + tech_type + ", health_license=" + health_license + ", approve_date=" + approve_date + ", run_status ="
				+ run_status  + ", charge_in_person=" + charge_in_person + "]";
	}
	
}
