package org.rodrigovelaz.geolocationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
@EnableSwagger2
public class GeolocationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeolocationServiceApplication.class, args);
	}

}