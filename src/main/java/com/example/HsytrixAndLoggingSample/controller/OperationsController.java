package com.example.HsytrixAndLoggingSample.controller;

import com.example.HsytrixAndLoggingSample.service.OperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RequestMapping("/v1")
@RestController
public class OperationsController {

    Logger logger = LoggerFactory.getLogger(OperationsController.class);

@Autowired
    private OperationsService operationsService;

@RequestMapping(value="/testOprations/{port}", method= RequestMethod.GET)
    public void testOperations(@PathVariable String port) {
    logger.info("inside the test operation method with port {} ",port);
    operationsService.testHystrix(port);

}

    @RequestMapping(value="/status", method= RequestMethod.GET)
    public String getStatus() {
        return "Success";


    }
}
