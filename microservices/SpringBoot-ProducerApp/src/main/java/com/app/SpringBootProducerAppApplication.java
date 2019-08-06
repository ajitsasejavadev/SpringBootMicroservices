package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient  /** This annotation used for activate or enable the eureka server and other server like zookeper**/
@EnableEurekaClient  /**It is used for enable or activate eureka server only**/
public class SpringBootProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerAppApplication.class, args);
	}

}
