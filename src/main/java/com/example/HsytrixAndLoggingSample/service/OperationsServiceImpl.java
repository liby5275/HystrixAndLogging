package com.example.HsytrixAndLoggingSample.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Component
public class OperationsServiceImpl implements OperationsService {

    Logger logger = LoggerFactory.getLogger(OperationsServiceImpl.class);

    String URL1="http://localhost:";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "ReadingMockService", commandKey = "ReadingMockService", threadPoolKey = "ReadingMockService", fallbackMethod = "fallBackMethod", commandProperties = {
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds", value = "300000"),
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage", value = "50")})
    
    @Override
    public void testHystrix(String portNumber) {
        logger.info("inside vulnarable method");
        String url =  URL1+portNumber+"/v1/status";
        URI uri = URI.create(url);
        logger.info("URI is " +uri);
        String status = restTemplate.getForObject(uri,String.class);
        logger.info("Third party call is successfull and the status is {} ",status);

    }

    @SuppressWarnings("unused")
	public void fallBackMethod(String portNumber) {
        logger.info("Service down in port");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
