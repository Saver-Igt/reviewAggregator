package dev.siraev.rest;

import dev.siraev.models.Game;
import dev.siraev.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping()
    public @ResponseBody
    List<Game> getGames() throws Exception{
        return gameService.getGames();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Game getGame(@PathVariable Long id) throws Exception{
        return gameService.getGame(id);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('games:write')")
    public @ResponseBody
    Game addGame(@RequestBody Game game) throws Exception{
        return gameService.addGame(game);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('games:write')")
    public@ResponseBody
    Game editGame(@PathVariable Long id, @RequestBody Game game) throws Exception{
        return gameService.editGame(id, game);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('games:write')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable Long id)throws Exception{
        gameService.deleteGame(id);
    }
}
