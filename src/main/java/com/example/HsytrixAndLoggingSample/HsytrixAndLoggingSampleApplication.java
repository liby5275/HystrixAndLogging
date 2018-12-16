package com.example.HsytrixAndLoggingSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
public class HsytrixAndLoggingSampleApplication {


	public static void main(String[] args) {
		SpringApplication.run(HsytrixAndLoggingSampleApplication.class, args);
	}

}

