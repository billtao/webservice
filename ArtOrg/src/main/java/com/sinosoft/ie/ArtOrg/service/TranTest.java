package com.sinosoft.ie.ArtOrg.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;

import com.sinosoft.ie.ArtOrg.entity.OrgInfo;
import com.sinosoft.ie.ArtOrg.entity.Record;
import com.sun.org.apache.bcel.internal.generic.NEW;;
@Service
public class TranTest {
	/*	
	 * 将查到的数据写成xml字符串
	*/	
	public void printXml(Record record) throws IOException {
		
        //获取数据库数据
//		ArrayList<OrgInfo> orgInfos = new ArrayList<OrgInfo>();
//		for (int i = 0; i < 4; i++) {
//			OrgInfo oInfo = new OrgInfo();
//			oInfo.setArea("北京");
//			oInfo.setAreacode("11"); 
//			oInfo.setOrgname("北京大学第三医院");
//			orgInfos.add(oInfo);
//		}
//        Record recordtest = new Record();
//       if (null != record) {
//    	   recordtest = record;
//	} 
//       System.out.println(recordtest.getUsername()+"*********************");
//        //转XML
//        StringBuffer xml = new StringBuffer();
//        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//        //<record>
//        xml.append("<record>\n");
//        xml.append("<uploadtime>");
//        xml.append(recordtest.getUploadtime());
//        xml.append("</uploadtime>\n");
//        xml.append("<title>");
//        //xml.append(recordtest.getTitle());
//        xml.append("</title>\n");
//        xml.append("<count>");
//        xml.append(recordtest.getCount());
//        xml.append("</count>\n");
//        xml.append("<orglist>\n");
//        
//        for(OrgInfo orgInfo : recordtest.getOrglist()){
//        	xml.append("  <orginfo>\n");
//        	xml.append("    <filedpk>");
//            xml.append(orgInfo.getFiledpk());
//            xml.append("</filedpk>\n");
//        	xml.append("    <areacode>");
//            xml.append(orgInfo.getAreacode());
//            xml.append("</areacode>\n");
//            xml.append("    <area>");
//            xml.append(orgInfo.getArea());
//            xml.append("</area>\n");
//            xml.append("    <orgcode>");
//            xml.append(orgInfo.getOrgcode());
//            xml.append("</orgcode>\n");
//            xml.append("    <orgname>");
//            xml.append(orgInfo.getOrgname());
//            xml.append("</orgname>\n");
//            xml.append("    <orglegalname>");
//            xml.append(orgInfo.getOrglegalname());
//            xml.append("</orglegalname>\n");
//            xml.append("    <orglegalcode>");
//            xml.append(orgInfo.getOrglegalcode());
//            xml.append("</orglegalcode>\n");
//            xml.append("    <project>");
//            xml.append(orgInfo.getProject());
//            xml.append("</project>\n");
//            xml.append("    <license>");
//            xml.append(orgInfo.getLicense());
//            xml.append("</license>\n");
//            xml.append("    <approvaldate>");
//            xml.append(orgInfo.getApprovaldate());
//            xml.append("</approvaldate>\n");
//            xml.append("    <runstates>");
//            xml.append(orgInfo.getRunstates());
//            xml.append("</runstates>\n");
//            xml.append("    <spermcontact>");
//            xml.append(orgInfo.getSpermcontact());
//            xml.append("</spermcontact>");
//            xml.append("\n  </orginfo>\n");
//        }
//        xml.append("</orglist>");
//       
//        
//        xml.append("\n</record>");
//        writefile(xml.toString());
    }
	/*
	 * 将xml字符串存到xml
	 * */
	public void writefile(String shardata) throws IOException {
		//获取当前包的service
		File directory = new File("");
		String url = directory.getCanonicalPath();
		String filename = "datashar.xml";
		File datafile = new File("D:\\"+filename);
		if (!datafile.exists()) {
			datafile.createNewFile();
//			datafile.mkdir();
		}else{
			datafile.delete();
			datafile.createNewFile();
		}
		PrintStream ps = new PrintStream(datafile);
		ps.println(shardata);
		ps.close();
	}
 
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	TranTest test = new TranTest();
        test.printXml(new Record());
       
//        File directory = new File("");
//		String url2 = directory.getAbsolutePath();
//        System.out.println(url2);
//        test.writefile("frwqetr");
    }
}
