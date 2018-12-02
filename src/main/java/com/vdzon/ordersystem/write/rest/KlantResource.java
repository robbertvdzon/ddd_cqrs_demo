package com.vdzon.ordersystem.write.rest;

import com.vdzon.ordersystem.write.domain.Klant;
import com.vdzon.ordersystem.write.repositories.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public void delete(@RequestBody Klant klant) {
        klantRepository.delete(klant);
    }

}
