package com.bekov.currency_database_server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RateDAO implements IRateDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void deleteDate(String date) {
        String sql = "DELETE FROM rate WHERE date=?";
        jdbcTemplate.update(sql, date);
    }

    @Override
    public void deleteAll() {

        String sql = "DELETE FROM rate";
        jdbcTemplate.update(sql);

    }
}
