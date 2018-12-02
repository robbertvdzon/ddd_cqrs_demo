package com.vdzon.ordersystem.domain.validation;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidatieException extends RuntimeException {

    private Set<ConstraintViolation<Object>> violations;

    public ValidatieException(Set<ConstraintViolation<Object>> violations) {
        this.violations = violations;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        violations.forEach(v -> {
            message.append(v.getMessage());
        });
        return message.toString();
    }
}
