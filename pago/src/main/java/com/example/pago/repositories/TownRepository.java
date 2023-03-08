package com.example.pago.repositories;

import com.example.pago.domains.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Town findByName(String name);
}
