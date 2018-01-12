package com.lhl.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 与<code>MyWebApplicationInitializer</code> 作用相同， 有相同的接口 
 * 此类父类提供有些便捷的方法<br>
 * 纯 java 代码实现
 * 
 * @author datatoucher
 *
 */
public class My2WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		// TODO Auto-generated method stub
		return new Class[]{MySpringConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		
		return new Class [] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[]{"/"};
	}

}
