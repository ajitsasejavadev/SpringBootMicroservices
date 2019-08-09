package com.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rest.consumer.DeptRestConsumer;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private DeptRestConsumer consumer;
	
	@GetMapping("/data")
	public String seeData(){
		System.out.println(consumer.getClass().getName());
		String msg=consumer.getAllDept().toString();
		return "ADMIN=>" +msg;
	}
	
	@GetMapping("/info")
	public String findVal() {
		String msg=consumer.getDept().toString();
		return "ADMIN==>"+msg;
	}
	
	@GetMapping("/id")
	public String getId() {
		String id=consumer.readId("25");
		return "ADMIN==>" +id;
	}
}
