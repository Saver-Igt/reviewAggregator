package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Game;
import com.example.reviewAggregator.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameServiceDB implements GameService {

    private final GameRepository gameRepository;
    private GameServiceDB(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }
    @Override
    public List<Game> getGames() throws Exception {
        return gameRepository.findAll();
    }

    @Override
    public Game getGame(int id) throws Exception {
        return gameRepository.findById(id).orElse(new Game());
    }

    @Override
    public Game addGame(Game game) throws Exception {
        return gameRepository.save(game);
    }

    @Override
    public Game editGame(int id, String name, String description) throws Exception {
        Game findGame = getGame(id);
        findGame.setName(name);
        findGame.setDescription(description);
        return gameRepository.save(findGame);
    }

    @Override
    public void deleteGame(int id) throws Exception {
        gameRepository.deleteById(id);
    }
}
