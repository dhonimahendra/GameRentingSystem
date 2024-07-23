package com.example.gamerentingsystem.controller;

import com.example.gamerentingsystem.model.Game;
import com.example.gamerentingsystem.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public Game addOrUpdateGame(@RequestBody Game game) {
        return gameService.addOrUpdateGame(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeGame(@PathVariable Long id) {
        String responseMessage = gameService.removeGame(id);
        return ResponseEntity.ok(responseMessage);
    }


    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}
