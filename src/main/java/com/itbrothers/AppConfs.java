package com.itbrothers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.itbrothers")
public class AppConfs {
	public AppConfs() {
		System.out.println("AppConfs constructor..");
	}

	/*	@Bean
	public MyBean1 MyBean1(){
		
	}*/
}
