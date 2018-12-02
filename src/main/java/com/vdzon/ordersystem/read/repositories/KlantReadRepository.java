package com.vdzon.ordersystem.read.repositories;

import com.vdzon.ordersystem.read.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantReadRepository extends JpaRepository<Klant, Long> {
}
