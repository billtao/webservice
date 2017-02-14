package com.sinosoft.ie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.ie.config.AuthConfig;
import com.sinosoft.ie.entity.OrgInfo;
import com.sinosoft.ie.web.OrgController;

/**
 * Hello world!
 *
 */

//@Configuration  
//@ComponentScan  
@EnableConfigurationProperties({AuthConfig.class})
@SpringBootApplication 
@EnableScheduling
public class App   extends SpringBootServletInitializer
{
	 private static Logger logger = LoggerFactory.getLogger(App.class); 
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(App.class);  
    }  
    
    public static void main( String[] args )
    {
       SpringApplication.run(App.class,args);
       logger.info("My Spring Boot Application Started"); 
    }
    
}
