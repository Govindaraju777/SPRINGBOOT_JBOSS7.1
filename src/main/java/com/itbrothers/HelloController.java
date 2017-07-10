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
