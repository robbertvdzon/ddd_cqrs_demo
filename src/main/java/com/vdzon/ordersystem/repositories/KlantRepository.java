package com.vdzon.ordersystem.repositories;

import com.vdzon.ordersystem.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantRepository extends JpaRepository<Klant, Long> {
}
