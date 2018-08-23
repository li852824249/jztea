package com.cn.ljz.tea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//此注解表示SpringBoot启动类
@SpringBootApplication
//开启事物管理
@EnableTransactionManagement 
//此注解表示动态扫描DAO接口所在包
@MapperScan("com.cn.ljz.tea.dao")
public class TeaApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class, args);
    }
	
}
