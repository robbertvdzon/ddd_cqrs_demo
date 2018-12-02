package com.vdzon.ordersystem.repositories;

import com.vdzon.ordersystem.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
