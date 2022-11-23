package com.example.reviewAggregator.controllers;

import com.example.reviewAggregator.models.Game;
import com.example.reviewAggregator.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/games")
public class GamesController {
    private final GameService gameService;
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public @ResponseBody
    List<Game> getGames() throws Exception{
        return gameService.getGames();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Game getGame(@PathVariable int id) throws Exception{
        return gameService.getGame(id);
    }
    @PostMapping
    public @ResponseBody
    Game addGame(@RequestBody Game game) throws Exception{
        return gameService.addGame(game);
    }
    @PutMapping("/{id}")
    public@ResponseBody
    Game editGame(@PathVariable int id,
                     @RequestBody String name,
                     @RequestBody String description
                     ) throws Exception{
        return gameService.editGame(id, name, description);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable int id)throws Exception{
        gameService.deleteGame(id);
    }
}
