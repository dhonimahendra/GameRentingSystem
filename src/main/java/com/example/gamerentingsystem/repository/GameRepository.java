package com.example.gamerentingsystem.repository;

import com.example.gamerentingsystem.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByTitleAndStudio(String title, String studio);
}
