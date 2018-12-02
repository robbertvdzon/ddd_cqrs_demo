package com.vdzon.ordersystem.repositories;

import com.vdzon.ordersystem.domain.Bestelling;
import com.vdzon.ordersystem.domain.validation.ValidatieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

@Service
public class BestellingRepository {
    @Autowired
    EntityManager entityManager;

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    @Transactional
    public void save(Bestelling bestelling) {
        validate(bestelling);
        entityManager.persist(bestelling);
    }

    public Optional<Bestelling> findById(long id) {
        return Optional.ofNullable(entityManager.find(Bestelling.class, id));
    }

    private void validate(Bestelling bestelling) {
        Set<ConstraintViolation<Object>> validate = validator.validate(bestelling);
        if (!validate.isEmpty()) {
            throw new ValidatieException(validate);
        }
    }


}
