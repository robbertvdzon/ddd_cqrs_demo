package com.vdzon.ordersystem.rest;

import com.vdzon.ordersystem.domain.Bestelling;
import com.vdzon.ordersystem.repositories.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bestelling")
public class BestellingResource {

    private final BestellingRepository bestellingRepository;

    @Autowired
    public BestellingResource(BestellingRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }

    @PostMapping
    public void save(@RequestBody Bestelling bestelling) {
        bestellingRepository.save(bestelling);
    }

    @GetMapping("all")
    public List<Bestelling> getAll() {
        return bestellingRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Bestelling> getById(@PathVariable long id) {
        return bestellingRepository
                .findById(id)
                .map(bestelling -> new ResponseEntity<>(bestelling, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Bestelling>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping()
    public void delete(@RequestBody Bestelling bestelling) {
        bestellingRepository.delete(bestelling);
    }

}
