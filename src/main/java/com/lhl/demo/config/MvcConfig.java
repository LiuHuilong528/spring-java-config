package com.lhl.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * SpringMVC-servlet.xml 相同
 * @author datatoucher
 *
 */

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.lhl.demo.*", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION))
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * Jsp 视图解析器
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	/**
	 * 文件流解析器
	 * 
	 * @return
	 */
//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver getMultipartResolver() {
//		return new CommonsMultipartResolver();
//	}

	/**
	 * 返回字符串乱码——统一返回UTF-8编码
	 * 
	 * @return
	 */
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	/**
	 * 映射静态访问路径
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 静态资源访问
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
