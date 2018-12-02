package com.vdzon.ordersystem.write.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BestellingValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Bestelling.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bestelling bestelling = (Bestelling) target;
        if (bestelling.getBestelRegels().size() > 3) {
            errors.rejectValue("bestelRegels", "maximaal 3 bestelregels per bestelling");
        }
        if (bestelling.getBestelRegels().stream().mapToDouble(r -> r.getAantal() * r.getStuksPrijs()).sum() > 1000) {
            errors.rejectValue("bestelRegels", "maximaal 1000 euro per bestelling");
        }
        double totaalBedrag = bestelling.getBestelRegels()
                .stream()
                .mapToDouble(r->r.getAantal()*r.getStuksPrijs())
                .sum();
        if (bestelling.getTotaalBedrag()!=totaalBedrag) {
            errors.rejectValue("bestelRegels", "totaalBedrag klopt niet");
        }
    }

}
