package com.code.test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//web.xml
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
		context.register(SpringMVCConfig.class); //spring-servlet.xml
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(context));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
