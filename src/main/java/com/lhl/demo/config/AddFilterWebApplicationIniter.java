package com.lhl.demo.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AddFilterWebApplicationIniter extends AbstractDispatcherServletInitializer 
{

	@Override
	protected WebApplicationContext createServletApplicationContext()
	{
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		return cxt;
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext()
	{
		return null;
	}

}
