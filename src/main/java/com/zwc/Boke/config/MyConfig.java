package com.zwc.Boke.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
	
	@Value("${file.path}")
	private String path;
	
	@Value("${file.url}")
	private String url;
	 
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	*//**
    	 * 配置默认首页:forward转发(或controller("/")或首页直接放在static文件夹下)
    	 *//*
        registry.addViewController("/").setViewName("forward:/my");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }*/ 
    @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {		  
		  registry.addResourceHandler(url).addResourceLocations("file:"+path);
		  super.addResourceHandlers(registry);
	  }
}
