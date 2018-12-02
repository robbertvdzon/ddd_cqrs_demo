package com.vdzon.ordersystem.read.rest;

import com.vdzon.ordersystem.read.domain.ReadKlant;
import com.vdzon.ordersystem.read.repositories.KlantReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("klant")
public class KlantReadResource {
    private final KlantReadRepository klantRepository;

    @Autowired
    public KlantReadResource(KlantReadRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @GetMapping("all")
    public List<ReadKlant> getAll() {
        return klantRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadKlant> getById(@PathVariable long id) {
        return klantRepository
                .findById(id)
                .map(klant -> new ResponseEntity<>(klant, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<ReadKlant>(HttpStatus.NOT_FOUND));
    }


}
