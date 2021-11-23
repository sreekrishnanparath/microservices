package com.marshal.microservices.currencyconversionservice;

import com.marshal.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;


//@FeignClient(name="currency-exchange",url = "localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to);


}
