package com.vdzon.ordersystem.write.rest;

import com.vdzon.ordersystem.write.domain.Bestelling;
import com.vdzon.ordersystem.write.domain.ValidatieException;
import com.vdzon.ordersystem.write.repositories.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
        bestellingRepository.save(bestelling);
        System.out.println(bestelling);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(ValidatieException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
