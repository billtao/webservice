package com.sinosoft.ie.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.sinosoft.ie.entity.OperationResult;
import com.sinosoft.ie.service.Layout;
@javax.jws.WebService(  
        serviceName = "LayoutServiceImpl", portName = "LayoutImpl",  
        targetNamespace = "http://service.webservice.com/",  
        endpointInterface = "com.sinosoft.ie.service.Layout")  
public class LayoutImpl implements Layout {
	private static final Logger LOG = LoggerFactory.getLogger(LayoutImpl.class);  
	@Override
	public String sayhello(String name) {
		// TODO Auto-generated method stub
		 return "hello," + name;  
	}

	@Override
	public OperationResult addLayout(String layoutName, String layoutContent) {
		// TODO Auto-generated method stub
		LOG.info("layoutName:{}, layoutContent:{}", layoutName, layoutContent);  
        if (StringUtils.isEmpty(layoutName) || StringUtils.isEmpty(layoutContent)) {  
            return new OperationResult(false, "参数不能为空");  
        }  
  
        //TODO  
        return new OperationResult(true, null);  
	}

}
