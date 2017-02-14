package com.sinosoft.ie.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.sinosoft.ie.entity.OperationResult;

@WebService(name = "LayoutService", targetNamespace = "http://service.webservice.com/")  
public interface Layout {
	@WebMethod
	String sayhello(@WebParam(name = "name") String name);
	
	
	 @WebMethod  
	    OperationResult addLayout(@WebParam(name = "layoutName")    String layoutName,  
	                              @WebParam(name = "layoutContent") String layoutContent);  

}
