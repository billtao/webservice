package com.sinosoft.ie.ArtOrg.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration
@RestController 
@RequestMapping("/te1")  
public class DateSharingController {
	 @RequestMapping("/test1")  
	    @ResponseBody
	    public String hello() {  
	    	return "Hello world!"; 
	    }  
}
