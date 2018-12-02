package com.vdzon.ordersystem.read.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SummaryReadRepository {
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public SummaryReadRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public double getTotal() {
        return jdbcTemplate.queryForObject("SELECT sum(totaal_Bedrag) from Bestelling", Double.class);
    }
}
