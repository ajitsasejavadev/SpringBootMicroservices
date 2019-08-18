package com.app.rest.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/cust")
public class CustomerRestController {

	@GetMapping("/show")
	@HystrixCommand(fallbackMethod="showFallBack")
	public String showData() {
		
		System.out.println("From Actual Service");
		if(new Random().nextInt(15)<=10) {
			throw new RuntimeException("DUMMY");
		}
		return "Hello Customer";	
	}
	
	public String showFallBack() {
		
		System.out.println("From FallBack Method..");
		return "Hello: From FallBack Method";}
}
