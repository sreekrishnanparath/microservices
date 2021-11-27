package com.marshal.microservices.currencyconversionservice;

import com.marshal.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;


//@FeignClient(name="currency-exchange",url = "localhost:8000") //default hardcoded configuration
//@FeignClient(name="currency-exchange")//eureka configuration
@FeignClient(name="currency-exchange",url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000") // kubernetes config
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to);


}
