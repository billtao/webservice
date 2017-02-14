package com.sinosoft.ie.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.ie.ArtOrg.entity.Record;
import com.sinosoft.ie.ArtOrg.service.DataSharingService;
import com.sinosoft.ie.ArtOrg.service.TranTest;
import com.sinosoft.ie.config.AuthConfig;
import com.sinosoft.ie.entity.OrgInfo;
import com.sinosoft.ie.utils.JaxbUtil;

@EnableAutoConfiguration
@RestController 
@RequestMapping("/orginfo")  
public class OrgController {
	@Autowired
	private AuthConfig authConfig;
	
	@Autowired
	DataSharingService dataSharingServices;
	@Autowired
	TranTest trantest;	
	
	    @RequestMapping("/{areaCode}")  
	    @ResponseBody
	    public OrgInfo view(@PathVariable("areaCode") String areaCode) {  
	    	OrgInfo org = new OrgInfo();  
	        org.setAreaCode(areaCode);  
	        org.setOrgName("beijing"+" :");  
	        return org;  
	    }  
	    @RequestMapping("/h")  
	    @ResponseBody
	    public Object hello() throws IOException {
	    	Record result = dataSharingServices.dataquery();
	    	result.setUsername(authConfig.getUsername());
	    	result.setPassword(authConfig.getPassword());
	    	result.setBiztype(authConfig.getBiztype());
	    	result.setOrgcode(authConfig.getOrgcode());
	    	result.setServicetype(authConfig.getServicetype());
	    	String xml = JaxbUtil.convertToXml(result);
	    	//writefile(xml);
	    	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();///layout
	    	String wString = "http://localhost:8080/webservices/layout?wsdl";
	    	//String ws = "http://60.247.48.102/cimp/services/fysdataaccessService?wsdl";
	    	//String ws = "http://10.192.5.190:8082/cimp/services/fysdataaccessService?wsdl";
	    	String ws ="http://10.192.5.190:8082/cimp/services/fysdataaccessService?wsdl";

			Client client = dcf.createClient(ws);
			SAXReader reader = new SAXReader();  
			Document document = null;
			try {
				document =reader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Element root = document.getRootElement();
		Element ticket = null;

		Iterator tickets = null;
		Element _tElement = null;
		for (tickets = root.element("orglist").elementIterator(); tickets.hasNext();) {
			ticket = (Element) tickets.next();
			for(Object el:ticket.elements()){
				_tElement = (Element) el;
				_tElement.setAttributeValue("type","string");
			}
			ticket.element("id").setAttributeValue("length", "40");
			ticket.element("institution_name").setAttributeValue("length", "200");
			ticket.element("area_code").setAttributeValue("length", "50");
			ticket.element("area").setAttributeValue("length", "50");
			ticket.element("ocode").setAttributeValue("length", "10");
			ticket.element("corporate").setAttributeValue("length", "50");
			ticket.element("corporate_regnumber").setAttributeValue("length", "50");
			ticket.element("tech_type").setAttributeValue("length", "200");
			ticket.element("health_license").setAttributeValue("length", "80");
			ticket.element("approve_date").setAttributeValue("length", "200");
			ticket.element("run_status").setAttributeValue("length", "200");
			ticket.element("charge_in_person").setAttributeValue("length", "50");
		}
		writefile(document.asXML());
//			Object[] objects = client.invoke("getUser", 10002L);
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
				return objects[0].getClass()+" , "+objects[0].toString();
				//System.out.println(objects[0].toString());
			}else{
				return "返回结果异常或者结果为空！"; 
			}
			
	    	
	    }  
	    public static void writefile(String shardata) throws IOException {
			//获取当前包的service
			File directory = new File("");
			String url = directory.getCanonicalPath();
			String filename = "datashar.xml";
			File datafile = new File("D:\\"+filename);
			if (!datafile.exists()) {
				datafile.createNewFile();
//				datafile.mkdir();
			}else{
				datafile.delete();
				datafile.createNewFile();
			}
			PrintStream ps = new PrintStream(datafile);
			ps.println(shardata);
			ps.close();
		}
	    
	    
}
