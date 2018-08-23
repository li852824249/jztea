package com.cn.ljz.tea.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfiguration {

	private Logger log = LoggerFactory.getLogger(DruidConfiguration.class); 
	
	@Bean(name="dataSource", destroyMethod = "close",initMethod = "init")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
	
	@Bean
    public ServletRegistrationBean druidStatViewServlet() {
		log.info("----------------init Druid Servlet Configuration -----------------------");
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("deny", "");
        //控制台管理用户
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

	@Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
