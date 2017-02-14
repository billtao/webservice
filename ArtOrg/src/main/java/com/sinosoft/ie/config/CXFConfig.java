package com.sinosoft.ie.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.sinosoft.ie.interceptor.AuthInterceptor;
import com.sinosoft.ie.service.Layout;
import com.sinosoft.ie.service.impl.LayoutImpl;
@Configuration
public class CXFConfig {

	@Bean(name = Bus.DEFAULT_BUS_ID)  
    public SpringBus springBus() {  
        return new SpringBus();  
    }  
  
    @Bean  
    public Layout layout() {  
        return new LayoutImpl();  
    }  
  
    @Bean  
    public Endpoint endpoint() {  
        EndpointImpl endpoint = new EndpointImpl(springBus(), layout());  
        endpoint.publish("/layout");  
       // endpoint.getInInterceptors().add(new AuthInterceptor());   //鉴权
        return endpoint;  
    }  
//    @Bean  
//    public ServletRegistrationBean servletRegistrationBean() {  
//        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/webservice/*");  
//        bean.setLoadOnStartup(0);  
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
//        return bean;  
//    }  
}
