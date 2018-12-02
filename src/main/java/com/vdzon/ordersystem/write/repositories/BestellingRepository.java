package com.vdzon.ordersystem.write.repositories;

import com.vdzon.ordersystem.write.domain.Bestelling;
import com.vdzon.ordersystem.write.domain.BestellingValidator;
import com.vdzon.ordersystem.write.domain.ValidatieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BestellingRepository {
    final
    EntityManager entityManager;

    @Autowired
    public BestellingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    public void save(Bestelling bestelling) {
        validate(bestelling);
        entityManager.persist(bestelling);
    }

    public Optional<Bestelling> findById(long id) {
        return Optional.ofNullable(entityManager.find(Bestelling.class, id));
    }

    private void validate(Bestelling bestelling) {
        DataBinder dataBinder = new DataBinder(bestelling);
        dataBinder.addValidators(new BestellingValidator());
        dataBinder.validate();
        if (dataBinder.getBindingResult().hasErrors()) {
            throw new ValidatieException(dataBinder.getBindingResult().toString());
        }
    }


}
