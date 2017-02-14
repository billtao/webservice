package com.sinosoft.ie.ArtOrg.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.ie.ArtOrg.entity.Attribute;
import com.sinosoft.ie.ArtOrg.entity.OrgInfo;
import com.sinosoft.ie.ArtOrg.entity.OrgInfoMap;
import com.sinosoft.ie.ArtOrg.entity.Record;


@Service
public class DataSharingService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	List orglist = new ArrayList<OrgInfo>();
	@Transactional(readOnly=true)
	public Record dataquery() {
		StringBuffer sql = new StringBuffer();
		StringBuffer countrow = new StringBuffer();
		sql.append("select distinct project.field_pk id, ");//---技术表主键，作为唯一性标识
		sql.append("org.org_areaid as area_code, ");//--"行政区划代码",
		sql.append("getcodevalue('udp_v_dd_0003',");
		sql.append(" subStr(org.org_areaid, 0, 2) || '0000') as area,");//--"行政区划",
		sql.append("org.org_organizationcode as ocode,");// --"组织机构代码",   
		sql.append(" org.org_name as institution_name,");//--"机构名称",
		sql.append(" org.org_legalname as corporate,");//--"机构法人",
		sql.append("org.org_legalnumber as corporate_regnumber,");//--"法人登记号",
		sql.append(" getcodevalue('udp_r_dd_0003', project.por_porjects) as tech_type,");//-- "准入技术",
		sql.append("org.pro_license as health_license,");//--"许可证登记号",
		sql.append("NVL(org.org_spermbank_contact,'') as charge_in_person,");//--"精子库负责人",
		sql.append(" project.column_6 as approve_date,");//-- "批准时间",
		sql.append(" (select t.dd_order");
		sql.append("  from udp_r_dd_0003 t");
		sql.append("  where t.dd_id = project.por_porjects) as projects_no,");
		sql.append("  getcodevalue('udp_r_dd_0007', project.pro_type) as run_status,");// --"运行状态",
		sql.append(" subStr(org.org_areaid, 0, 2) || '0000' as org_areaid_code,");
		sql.append(" to_char((select count(*)");
		sql.append(" from (select distinct org.org_name,");
		sql.append("subStr(org.org_areaid, 0, 2) as org_areaid");
		sql.append("  from pro_org org, pro_project project");
		sql.append("  where org.field_pk = project.pro_orgid");
		sql.append("  and project.pro_type in (1, 2)");
		sql.append(" and org_areaid is not null");
		sql.append(" and 1 = 1");
		sql.append("  and 1 = 1) r");
		sql.append("  where r.org_areaid = subStr(org.org_areaid, 0, 2)");
		sql.append("  GROUP by org_areaid)) as jgzs");
		sql.append("  from pro_org org, pro_project project");
		sql.append(" where org.field_pk = project.pro_orgid");
		sql.append(" and project.pro_type in (1, 2)");
		sql.append(" and org_areaid is not null");
		sql.append("  and org.org_type in ('001')");
		sql.append("  and org_areaid is not null");
		sql.append(" and 1 = 1 and 1 = 1 and 1 = 1");
		sql.append("  order by org_areaid_code, project.column_6, org_name, projects_no");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		countrow.append("select to_char(count(*)) num  from(");
		countrow.append(sql);
		countrow.append(")");
		countrow.append("");
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		Map<String, Object> count = jdbcTemplate.queryForMap(countrow.toString());
		List<OrgInfoMap> om = new ArrayList<OrgInfoMap>();
		OrgInfo orginfo = null;
		for (Map<String, Object> map : list) {
			orginfo = new  OrgInfo();
			orginfo.setId((String)map.get("id")==null?"":(String)map.get("id"));
			orginfo.setArea_code((String)map.get("area_code")==null?"":(String)map.get("area_code"));
			orginfo.setArea((String)map.get("area")==null?"":(String)map.get("area"));
			orginfo.setOcode((String)map.get("ocode")==null?"":(String)map.get("ocode"));
			orginfo.setInstitution_name((String)map.get("institution_name")==null?"":(String)map.get("institution_name"));
			orginfo.setCorporate((String)map.get("corporate")==null?"":(String)map.get("corporate"));
			orginfo.setCorporate_regnumber((String)map.get("corporate_regnumber")==null?"":(String)map.get("corporate_regnumber"));
			orginfo.setTech_type((String)map.get("tech_type")==null?"":(String)map.get("tech_type"));
			orginfo.setHealth_license((String)map.get("health_license")==null?"":(String)map.get("health_license"));
			orginfo.setApprove_date((String)map.get("approve_date")==null?"":(String)map.get("approve_date"));
			orginfo.setRun_status((String)map.get("run_status")==null?"":(String)map.get("run_status"));
			orginfo.setCharge_in_person((String)map.get("charge_in_person")==null?"":(String)map.get("charge_in_person"));
			//orginfo.setType("String");
			 
			orglist.add(orginfo);
		 
		}
		Record record = new Record();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		record.setSendtime(df.format(new Date()));
		record.setCount((String)count.get("num"));
		record.setOrglist(orglist);
	 
		return record;
	}
	
	public Object  ss() {
		Object aObject = jdbcTemplate.queryForList("select * from pro_org");
		System.out.println(aObject);
		return aObject;
	}
	
}
