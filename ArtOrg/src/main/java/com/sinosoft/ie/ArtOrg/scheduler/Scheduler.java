package com.sinosoft.ie.ArtOrg.scheduler;


import java.io.IOException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.sinosoft.ie.ArtOrg.entity.Record;
import com.sinosoft.ie.ArtOrg.service.DataSharingService;
import com.sinosoft.ie.ArtOrg.service.TranTest;
import com.sinosoft.ie.config.AuthConfig;
import com.sinosoft.ie.utils.JaxbUtil;

@Component
public class Scheduler {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	 @Autowired
	 private AuthConfig authConfig;
     @Autowired
     DataSharingService dataSharingServices;
     @Autowired
     TranTest trantest;
	    @Scheduled(cron="1 1 0 1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31 * *") //每分钟执行一次  //每月01：01：01触发，每两天执行一次
	    public void statusCheck() throws IOException {      
    	Record result = dataSharingServices.dataquery();
	 	result.setUsername(authConfig.getUsername());
	 	result.setPassword(authConfig.getPassword());
	 	result.setBiztype(authConfig.getBiztype());
	 	result.setOrgcode(authConfig.getOrgcode());
	 	result.setServicetype(authConfig.getServicetype());
	 	String xml = JaxbUtil.convertToXml(result);
	 	trantest.writefile(xml);
	 	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();///layout
	 	String wString = "http://localhost:8080/webservices/layout?wsdl";
	 	String ws = "http://60.247.48.102/cimp/services/fysdataaccessService?wsdl";
		Client client = dcf.createClient(ws);
		
//		Object[] objects = client.invoke("getUser", 10002L);
		Object[] objects = null;
		try {
			objects = client.invoke("dataAccess",xml.getBytes());
			//objects = client.invoke("sayhello","junjie");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出调用结果
		if(objects!=null){
			logger.info( objects[0].getClass()+" , "+objects[0].toString()); 
			//System.out.println(objects[0].toString());
		}else{
			logger.info("返回结果异常或者结果为空！");  
		}
	        logger.info("每月01：01：01触发，每两天执行一次。结束。");  
	    }    
	  
//	    @Scheduled(fixedRate=5000)  
//	    public void testTasks() throws IOException {  
//	    	Record resulat = dataSharingServices.dataquery();
//	    	resulat.setUsername(authConfig.getUsername());
//	    	resulat.setPassword(authConfig.getPassword());
//	    	resulat.setBiztype(authConfig.getBiztype());
//	    	resulat.setOrgcode(authConfig.getOrgcode());
//	    	resulat.setServicetype(authConfig.getServicetype());
//	    	String result = JaxbUtil.convertToXml(resulat);
//	    	System.out.println(JaxbUtil.convertToXml(resulat));
	    	
	    	//resulat.setUsername(authConfig.getUsername());
//	    	logger.info("每20秒执行一次。开始……");  
//	        //statusTask.healthCheck();  
//	        logger.info("每20秒执行一次。结束。");  
//	    }    
}
