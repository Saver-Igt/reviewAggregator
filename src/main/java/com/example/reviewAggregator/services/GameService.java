package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Game;

import java.util.List;

public interface GameService {
    List<Game> getGames() throws Exception;

    Game getGame(int id) throws Exception;

    Game addGame(Game game) throws Exception;

    Game editGame(int id, String name, String description) throws Exception;

    void deleteGame(int id) throws Exception;
}
