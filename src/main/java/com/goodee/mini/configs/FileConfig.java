package com.goodee.mini.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FileConfig implements WebMvcConfigurer {

	@Value("${app.upload}")
	private String path;
	
	@Value("${app.url}")
	private String url;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(url).addResourceLocations("file: " + path);
	}
}
