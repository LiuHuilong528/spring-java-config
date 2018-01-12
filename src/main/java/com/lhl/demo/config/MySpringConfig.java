package com.lhl.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 与 ApplicationContext.xml 相同 Spring容器bean
 * 
 * @author datatoucher
 *
 */

@Configuration
@ComponentScan(basePackages = "com.lhl.demo.*", excludeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION))
public class MySpringConfig
{

}
