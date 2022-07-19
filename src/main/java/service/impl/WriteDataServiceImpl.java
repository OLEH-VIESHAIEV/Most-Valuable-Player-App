package service.impl;

import java.util.List;
import model.Game;
import service.GameHandlerStrategy;
import service.WriteDataService;

public class WriteDataServiceImpl implements WriteDataService {
    private GameHandlerStrategy gameHandlerStrategy;

    public WriteDataServiceImpl(GameHandlerStrategy gameHandlerStrategy) {
        this.gameHandlerStrategy = gameHandlerStrategy;
    }

    @Override
    public void apply(List<Game> games) {
        for (Game game : games) {
            Game.GameName gameName = game.getGameName();
            gameHandlerStrategy.get(gameName).process(game);
        }
    }
}
