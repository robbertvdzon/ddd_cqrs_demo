package com.vdzon.ordersystem.read.rest;

import com.vdzon.ordersystem.read.repositories.BestellingReadRepository;
import com.vdzon.ordersystem.read.repositories.SummaryReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("summary")
public class SummaryReadResource {

    private final SummaryReadRepository summaryReadRepository;

    @Autowired
    public SummaryReadResource(SummaryReadRepository summaryReadRepository) {
        this.summaryReadRepository = summaryReadRepository;
    }

    @GetMapping("total")
    public double getTotal() {
        return summaryReadRepository.getTotal();
    }


}
