package com.marshal.microservices.myfirstmicroservice.controller;


import com.marshal.microservices.myfirstmicroservice.bean.Limits;
import com.marshal.microservices.myfirstmicroservice.configurations.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private configuration configuration;


    @GetMapping("/limits")
    public Limits getLimits(){
        //return new Limits(1,1000);
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
