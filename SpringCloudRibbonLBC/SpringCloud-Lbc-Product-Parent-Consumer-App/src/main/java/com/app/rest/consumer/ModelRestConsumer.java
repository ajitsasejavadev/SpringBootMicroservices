package com.app.rest.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModelRestConsumer {

	/**.. Step#1: Use Object OF LoadBalanacer(Ribbon) Client Object(@Autowired) **/
	@Autowired
	private LoadBalancerClient lbc;

	public String getInfo() {

		/** Print the LoadBalancer Implementation Class Name**/
		System.out.println(lbc.getClass().getName());

		/**..Step#2: ByUsing ServiceID Call Choose Method Which Communicate 
		 * with LBS registry and returns Service Instance Object**/
		ServiceInstance si=lbc.choose("MODEL-CONSUMER");
		
		/**..Step#3: Read the URI And Construct The URL and Make a HttpRequest..**/
		URI u=si.getUri();
		return new RestTemplate()
				.getForEntity(u+"/model/info",
						String.class)
				.getBody();

	}

	public String getOne() {
		return new RestTemplate()
				.getForEntity(
						lbc.choose("MODEL-CONSUMER")
						.getUri()+"/model/one",
						String.class)
				.getBody();
	}


	public String getAll() {
		return new RestTemplate()
				.getForEntity(
						lbc.choose("MODEL-CONSUMER")
						.getUri()+"/model/all",
						String.class)
				.getBody();
	}

}
