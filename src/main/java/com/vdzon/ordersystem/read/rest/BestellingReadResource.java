package com.vdzon.ordersystem.read.rest;

import com.vdzon.ordersystem.read.domain.ReadBestelling;
import com.vdzon.ordersystem.read.repositories.BestellingReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bestelling")
public class BestellingReadResource {

    private final BestellingReadRepository bestellingRepository;

    @Autowired
    public BestellingReadResource(BestellingReadRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadBestelling> getById(@PathVariable long id) {
        return bestellingRepository
                .findById(id)
                .map(bestelling -> new ResponseEntity<>(bestelling, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<ReadBestelling>(HttpStatus.NOT_FOUND));
    }


}
