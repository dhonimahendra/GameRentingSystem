package com.example.gamerentingsystem.service;

import com.example.gamerentingsystem.model.Game;
import com.example.gamerentingsystem.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public Game addOrUpdateGame(Game game) {
        Optional<Game> existingGame = gameRepository.findByTitleAndStudio(game.getTitle(), game.getStudio());
        if (existingGame.isPresent()) {
            Game updateGame = existingGame.get();
            updateGame.setGenres(game.getGenres());
            return gameRepository.save(updateGame);
        } else {
            return gameRepository.save(game);
        }
    }

    @Transactional
    public String removeGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        gameRepository.deleteById(gameId);
        return "Game '" + game.getTitle() + "' by " + game.getStudio() + " was deleted successfully.";
    }
    

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
