package com.example.pago.repositories;

import com.example.pago.domains.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByOrderByRatingDesc();
    List<Game> findTop4ByOrderByRatingDesc();
}
