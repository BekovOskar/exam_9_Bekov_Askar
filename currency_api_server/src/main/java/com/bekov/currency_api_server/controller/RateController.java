package com.bekov.currency_api_server.controller;

import com.bekov.currency_api_server.model.Rate;
import com.bekov.currency_api_server.proxy.RateDBProxy;
import com.bekov.currency_api_server.proxy.RateWebProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
public class RateController  {

    @Autowired
    RateWebProxy rateWebProxy;

    @Autowired
    RateDBProxy rateDBProxy;

    @GetMapping("chekRate")
    @HystrixCommand(fallbackMethod = "getRateDB")
    public List<Rate> getRateWeb() throws ParserConfigurationException, SAXException, IOException {
        List<Rate> rateWeb = rateWebProxy.downloadRateInfo();
        for (Rate rate : rateWeb){
            rateDBProxy.postRate(rate);
        }




        return rateWebProxy.downloadRateInfo();
    }

    public List<Rate> getRateDB(){
        return rateDBProxy.getRate();
    }

    public Rate postRateDB(Rate rate){
        return rateDBProxy.postRate(rate);
    }


}
