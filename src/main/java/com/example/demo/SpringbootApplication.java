package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo"})
@ComponentScan(basePackages={"com.example.demo.controller"})
@ComponentScan(basePackages={"com.example.demo.service"})
@ComponentScan(basePackages={"com.example.demo.repository"})
@EntityScan(basePackages={"com.example.demo"})
@EnableJpaRepositories(basePackages= {"com.example.demo"})
public class SpringbootApplication extends SpringBootServletInitializer{
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SpringbootApplication.class);
	    }
	 

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(
				SpringbootApplication.class);
		        sa.run(args);
	}
}
