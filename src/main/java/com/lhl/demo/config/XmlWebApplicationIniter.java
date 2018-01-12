package com.lhl.demo.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * XML + java 代码实现
 * 
 * @author datatoucher
 *
 */
public class XmlWebApplicationIniter extends AbstractDispatcherServletInitializer
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
		// TODO Auto-generated method stub
		return new String[]
		{ "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext()
	{
		return null;
	}

}
