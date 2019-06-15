package com.bekov.currency_api_server.proxy;

import com.bekov.currency_api_server.model.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@FeignClient("CurrencyWebServer")
public interface RateWebProxy {


    @GetMapping("/rate")
    List<Rate> downloadRateInfo() throws IOException, ParserConfigurationException, SAXException;
}
