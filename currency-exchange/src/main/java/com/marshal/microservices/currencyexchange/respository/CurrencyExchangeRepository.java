package com.marshal.microservices.currencyexchange.respository;

import com.marshal.microservices.currencyexchange.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface  CurrencyExchangeRepository  extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from,String to);

}
