package com.vdzon.ordersystem.domain.validation;

import com.vdzon.ordersystem.domain.Bestelling;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BestellingValidator implements ConstraintValidator<ValidBestelling, Bestelling> {
    @Override
    public boolean isValid(Bestelling bestelling, ConstraintValidatorContext context) {
        return bestelling.getBestelRegels().size()<3;

    }
}
