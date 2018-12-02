package com.vdzon.ordersystem.rest;

import com.vdzon.ordersystem.domain.Bestelling;
import com.vdzon.ordersystem.repositories.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("bestelling")
public class BestellingResource {

    private final BestellingRepository bestellingRepository;

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();


    @Autowired
    public BestellingResource(BestellingRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }

    @PostMapping
    public void save(@RequestBody Bestelling bestelling) {
        bestellingRepository.save(bestelling);
    }

    @PostMapping("addRegel")
    public void addRegel(
            @RequestParam("bestelid") long bestelId,
            @RequestParam("productnaam") String productNaam,
            @RequestParam("aantal") int aantal,
            @RequestParam("stuksprijs") double stuksprijs
    ) {
        Bestelling bestelling = bestellingRepository.findById(bestelId).orElse(new Bestelling(bestelId));
        bestelling.addRegel(productNaam, aantal, stuksprijs);
        Set<ConstraintViolation<Bestelling>> validate = validator.validate(bestelling);
        if (!validate.isEmpty()) {
            throw new RuntimeException("No valid!");
        }
        Bestelling saved = bestellingRepository.saveAndFlush(bestelling);
        System.out.println(bestelling);
        System.out.println(saved);
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
