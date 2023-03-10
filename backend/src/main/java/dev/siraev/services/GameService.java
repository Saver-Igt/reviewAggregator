package dev.siraev.services;

import dev.siraev.models.Game;

import java.util.List;

public interface  GameService {
    List<Game> getGames() throws Exception;

    Game getGame(Long id) throws Exception;

    Game addGame(Game game) throws Exception;

    Game editGame(Long id, Game game) throws Exception;

    void deleteGame(Long id) throws Exception;
}
