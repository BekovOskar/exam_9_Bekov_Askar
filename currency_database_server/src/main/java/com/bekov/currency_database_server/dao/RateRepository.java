package com.bekov.currency_database_server.dao;

import com.bekov.currency_database_server.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
        List<Rate> findByDate(String date);


}
