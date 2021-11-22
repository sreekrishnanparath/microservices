package com.marshal.microservices.currencyconversionservice.controller;

import com.marshal.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConverisonController {

    @Autowired
    Environment environment;

    @GetMapping("/currency-converison/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity){

        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion  = responseEntity.getBody();


        //CurrencyConversion currencyConversion = new CurrencyConversion(1001,from,to,new BigDecimal(1),quantity,new BigDecimal(1));

        //currencyConversion.setEnvironment(environment.getProperty("local.server.port"));
        return new CurrencyConversion(1001,from,to,currencyConversion.getConversionMultiple(),quantity,currencyConversion.getConversionMultiple().multiply(quantity),currencyConversion.getEnvironment());

    }
}
