//package com.lhl.demo.config;
//
//import java.util.ServiceConfigurationError;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// * 
// * @author datatoucher
// *
// */
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//
//	/**
//	 * 可以手动添加许多的 web.xml 中的配置
//	 */
//	@Override
//	public void onStartup(ServletContext container) throws ServletException {
//		
//		// 添加 SpringMVC DispathServlet
//		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
//		dispatcherServlet.register(MvcConfig.class);
//		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
//				new DispatcherServlet(dispatcherServlet));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//		
//		// 添加 Spring 容器-监听器
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(ServiceConfigurationError.class,MySpringConfig.class);// ,
//		container.addListener(new ContextLoaderListener(rootContext));
//
//		// 添加过滤器
//		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter("UTF-8");
//		encodeFilter.setForceEncoding(true);
//		container.addFilter("encodingFilter", encodeFilter).addMappingForUrlPatterns(null, false, "/*");
//		
//		// web 系统变量
//		container.setInitParameter("spring.profiles.default", "prod");
//	}
//
//}
