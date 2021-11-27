package com.marshal.microservices.currencyexchange.controller;


import com.marshal.microservices.currencyexchange.bean.CurrencyExchange;
import com.marshal.microservices.currencyexchange.respository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class currencyExchangeController {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    Environment environment;

    @GetMapping("/currency")
    public CurrencyExchange getExchangeaa(){
        //System.out.println("from"+from);
        return new CurrencyExchange(1001,"from","to",new BigDecimal(50));
    }

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchange getExchange(@PathVariable String from,@PathVariable String to){
        System.out.println("from"+from);

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
                //new CurrencyExchange(1001, from, to, new BigDecimal(50));
        String host = environment.getProperty("HOSTNAME");
        String version = "v1";
        currencyExchange.setEnvironment(environment.getProperty("local.server.port")+" - "+host+" - "+version);

        return currencyExchange;
    }
}
