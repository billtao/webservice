package com.sinosoft.ie.ArtOrg.entity;

import java.util.HashMap;
import java.util.Map;

public class OrgInfoMap {

	private Map<String,Attribute> properties;

	public Map<String, Attribute> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Attribute> properties) {
		this.properties = properties;
	}

	public OrgInfoMap() {
		properties = new  HashMap<String,Attribute>(); 
	}
}
