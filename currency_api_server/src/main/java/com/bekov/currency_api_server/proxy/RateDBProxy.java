package com.bekov.currency_api_server.proxy;

import com.bekov.currency_api_server.model.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CurrencyDatabaseServer")
public interface RateDBProxy {

    @GetMapping("/rates")
    List<Rate> getRate();

    @GetMapping("/rates/{date}")
    List<Rate> getRateByDate(@PathVariable("date") String date);

    @PostMapping("/rates")
    Rate postRate(@RequestBody Rate rate);

    @DeleteMapping("/rate")
    void deleteRate();

    @DeleteMapping("/rate/{date}")
    void deleteRateDate(@PathVariable("date") String date);


}
