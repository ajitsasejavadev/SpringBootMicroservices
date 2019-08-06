package com.app.controller.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class EmpRestController {

	//..Step#1: inject the DiscoveryClient interface.
	@Autowired
	private DiscoveryClient client;  /** Import the Interface which gives instances method..**/

	@GetMapping("/msg")
	public String getMsg() {

		//..step#2: Get ServiceIstance using ServiceId.
		List<ServiceInstance> list =client.getInstances("EMPLOYEE-PRODUCER");

		//..step#3: read one Service Instance.
		ServiceInstance si =list.get(0);

		//..step#4: Read URI(pkg:java.net) from SI..
		URI uri =si.getUri();

		//..step#5: Construct URL
		String URL=uri+ "/emp/show";
		
		//..step#6: make HTTP request with URL
		RestTemplate rt =new RestTemplate();
		
		ResponseEntity<String> resp =rt.getForEntity(URL, String.class);
		
		//..step#7: Read Response/final message(entity)

		String msg =resp.getBody();
		return "CONSUMER"+msg;
	}	 
}
