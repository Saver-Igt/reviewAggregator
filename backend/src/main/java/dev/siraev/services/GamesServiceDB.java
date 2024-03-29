package dev.siraev.services;

import dev.siraev.models.Game;
import dev.siraev.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GamesServiceDB implements GameService{
    private final GameRepository gameRepository;
    private GamesServiceDB(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }
    @Override
    public List<Game> getGames() throws Exception {
        return gameRepository.findAll();
    }

    @Override
    public Game getGame(Long id) throws Exception {
        return gameRepository.findById(id).orElse(new Game());
    }

    @Override
    public Game addGame(Game game) throws Exception {
        return gameRepository.save(game);
    }

    @Override
    public Game editGame(Long id, Game game) throws Exception {
        Game findGame = getGame(id);
        findGame.setName(game.getName());
        findGame.setDescription(game.getDescription());
        findGame.setIconURL(game.getIconURL());
        return gameRepository.save(findGame);
    }

    @Override
    public void deleteGame(Long id) throws Exception {
        gameRepository.deleteById(id);
    }
    @Override
    public void changeAvgRating(Long id, int rating) throws Exception{
        Game findGame = getGame(id);
        findGame.setAvgRate(rating);
        gameRepository.save(findGame);
    }
}
