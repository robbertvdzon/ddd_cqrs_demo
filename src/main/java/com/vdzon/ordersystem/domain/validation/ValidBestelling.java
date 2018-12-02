package com.vdzon.ordersystem.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = BestellingValidator.class)
@Documented
public @interface ValidBestelling {

    String message() default "{IpAddress.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
