package com.marshal.microservices.currencyexchange.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {



    @GetMapping("/sample-api")
    //@Retry(name="sample-api",fallbackMethod = "harcodedReturnMethod")
    @CircuitBreaker(name="sample-api",fallbackMethod = "harcodedReturnMethod")
    public String sampleApi(){
        System.out.println("sampleApi## ");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:9090/test",String.class);

        return responseEntity.getBody();
    }

    public String harcodedReturnMethod(Exception ex){
        return "harcodedReturnMethod";
    }
}
