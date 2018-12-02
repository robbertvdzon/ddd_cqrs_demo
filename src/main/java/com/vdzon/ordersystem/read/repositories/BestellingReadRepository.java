package com.vdzon.ordersystem.read.repositories;

import com.vdzon.ordersystem.read.domain.ReadBestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class BestellingReadRepository {
    final
    EntityManager entityManager;

    @Autowired
    public BestellingReadRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ReadBestelling> findById(long id) {
        return Optional.ofNullable(entityManager.find(ReadBestelling.class, id));
    }

}
