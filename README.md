# SPRINGBOOT_JBOSS7.1


This is sample spring boot application for running a Spring Boot application on JBoss 7.1.x

Steps :
1. Create a spring boot with java v 1.7 (jboss7 does not support java8) and packaging as war.
2. After creating project change pom.xml
	a) exclude embedded tomcat
	b) war file name change in build - <finalName>SPRINGBOOTJBOSS</finalName> 
3. create test RestController (HelloController.java)
	a)  test by run as spring boot 
		- localhost:8080/test.spring (or) localhost:8080/testJboss7 works fine


# Code Snippet

- HelloController.java

package com.itbrothers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author govindaraju.v
 *
 */
@RestController
public class HelloController {

	public HelloController() {
		System.out.println("HelloController ...");
	}
	
	@RequestMapping({"/test.spring","testJboss7"})
	public String testController(){
		System.out.println("testController ...");
		return "Hello";
	}
	
}

- pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.itbrothers</groupId>
	<artifactId>citadel</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<name>SpringBootJboss7</name>
	<description>Spring boot Deployment with jboss 7.1</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.7</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<finalName>SPRINGBOOTJBOSS</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


</project>




