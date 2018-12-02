package com.vdzon.ordersystem.rest;

import com.vdzon.ordersystem.domain.Klant;
import com.vdzon.ordersystem.repositories.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("klant")
public class KlantResource {
    private final KlantRepository klantRepository;

    @Autowired
    public KlantResource(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @PostMapping
    public void save(@RequestBody Klant klant) {
        klantRepository.save(klant);
    }

    @GetMapping("all")
    public List<Klant> getAll() {
        return klantRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Klant> getById(@PathVariable long id) {
        return klantRepository
                .findById(id)
                .map(klant -> new ResponseEntity<>(klant, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Klant>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public void delete(@RequestBody Klant klant) {
        klantRepository.delete(klant);
    }

}
