package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// mapper接口扫描
@MapperScan(basePackages = "com.example.demo.mapper")
// spring的组件扫描
@ComponentScan(basePackages = { "com.example.demo" })
@SpringBootApplication
public class XiaoyezhuApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XiaoyezhuApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XiaoyezhuApplication.class, args);
	}
}
