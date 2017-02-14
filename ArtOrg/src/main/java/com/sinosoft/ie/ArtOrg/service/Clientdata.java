package com.sinosoft.ie.ArtOrg.service;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.cxf.endpoint.Client;

public class Clientdata {
	public static void main(String[] args) throws Exception {		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();///layout
		Client client = dcf.createClient("http://localhost:8082/cimp/services/fysdataaccessService?wsdl");
//		Object[] objects = client.invoke("getUser", 10002L);http://60.247.48.102/cimp/services/fysdataaccessService?wsdl
//		http://localhost:8082/cimp/services/fysdataaccessService?wsdl
		File file = new File("src/data.xml");
		System.out.println(file.getName().toString());
		byte[] data = new byte[(int) file.length()];
		try {
			FileInputStream fi = new FileInputStream(file);
			int offset = 0;
			int numRead = 0;
			while (offset < data.length && (numRead = fi.read(data, offset, data.length - offset)) >= 0) {
				offset += numRead;
			}
			// 确保所有数据均被读取
			if (offset != data.length) {
				System.out.println("Could not completely read file " + file.getName());
			}
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data.length);
		Object[] objects = client.invoke("dataAccess", data);
//		Object[] objects = client.invoke("dataAccess", "byte");
		//输出调用结果
		System.out.println(objects[0].getClass());
		System.out.println(objects[0].toString());
	}
		
}
