package com.sinosoft.ie.ArtOrg.entity;

import javax.xml.bind.annotation.XmlAttribute;

import com.sun.xml.txw2.annotation.XmlElement;
 
public class Attribute {
	private String attName;
	@XmlAttribute(name="att2")
	private String type2;
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public int getLength2() {
		return length2;
	}
	public void setLength2(int length2) {
		this.length2 = length2;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 
	private int length2;
	private String value;

}
