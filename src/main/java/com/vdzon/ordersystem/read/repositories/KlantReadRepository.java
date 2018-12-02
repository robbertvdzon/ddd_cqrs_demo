package com.vdzon.ordersystem.read.repositories;

import com.vdzon.ordersystem.read.domain.ReadKlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantReadRepository extends JpaRepository<ReadKlant, Long> {
}
