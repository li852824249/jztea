package com.cn.ljz.tea.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class MyCustomizer {
	
	@Bean
	public EmbeddedServletContainerCustomizer add() {
		
		return container -> {
			 container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
	         container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
		};
		
	}
}
