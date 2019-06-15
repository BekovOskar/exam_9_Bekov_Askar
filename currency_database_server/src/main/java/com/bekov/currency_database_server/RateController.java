package com.bekov.currency_database_server;

import com.bekov.currency_database_server.dao.RateDAO;
import com.bekov.currency_database_server.dao.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RateController {
    @Autowired
    RateRepository rateRepository;

    @Autowired
    RateDAO rateDAO;

    @GetMapping("/rates")
    public List<Rate> getRate() {

        return rateRepository.findAll();
    }

    @GetMapping("/rates/{date}")
    public List<Rate> getRateByDate(@PathVariable("date") String date) {

        return rateRepository.findByDate(date);
    }

    @PostMapping("/rates")
    public Rate postRate(@RequestBody Rate rate) {

        return rateRepository.save(rate);
    }


    @DeleteMapping("/rate")
    public void deleteRate(){
        rateDAO.deleteAll();
    }

    @DeleteMapping("/rate/{date}")
    public void deleteRateDate(@PathVariable("date") String date){
        rateDAO.deleteDate(date);
    }


}
