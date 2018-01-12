package com.lhl.demo.config;

import java.util.ServiceConfigurationError;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 相当于 web.xml
 * 
 * @author datatoucher
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ServiceConfigurationError.class);// ,
																// JPAConfig.class,SecurityConfig.class

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));

		// add filter
		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter("UTF-8");
		encodeFilter.setForceEncoding(true);
		container.addFilter("encodingFilter", encodeFilter).addMappingForUrlPatterns(null, false, "/*");
		;

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(MvcConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
				new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

}
