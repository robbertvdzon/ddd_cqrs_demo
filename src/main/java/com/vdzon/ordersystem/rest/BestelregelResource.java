package com.vdzon.ordersystem.rest;

import com.vdzon.ordersystem.domain.Bestelregel;
import com.vdzon.ordersystem.repositories.BestelregelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bestelregel")
public class BestelregelResource {
    private final BestelregelRepository bestelregelRepository;

    @Autowired
    public BestelregelResource(BestelregelRepository bestelregelRepository) {
        this.bestelregelRepository = bestelregelRepository;
    }

    @PostMapping
    public void save(@RequestBody Bestelregel bestelregel) {
        validate(bestelregel);
        bestelregelRepository.save(bestelregel);
    }

    @GetMapping("all")
    public List<Bestelregel> getAll() {
        return bestelregelRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Bestelregel> getById(@PathVariable long id) {
        return bestelregelRepository
                .findById(id)
                .map(bestelregel -> new ResponseEntity<>(bestelregel, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Bestelregel>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public void delete(@RequestBody Bestelregel bestelregel) {
        bestelregelRepository.delete(bestelregel);
    }

    private void validate(Bestelregel bestelregel){
        // find all bestelregels met zelfde bestel_id en controleer of dat er niet meer dan 3 zijn
    }

}
