package com.vdzon.ordersystem.repositories;

import com.vdzon.ordersystem.domain.Bestelregel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestelregelRepository extends JpaRepository<Bestelregel, Long> {
}
