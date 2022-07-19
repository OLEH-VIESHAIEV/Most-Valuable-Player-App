package service.impl;

import java.util.List;
import model.Game;
import service.GameHandlerStrategy;
import service.ParseDataService;

public class ParseDataServiceImpl implements ParseDataService {
    @Override
    public void handleData(List<String> dataFromFile) {
        Game game = new Game();
        game.setGameName(Game.GameName.valueOf(dataFromFile.get(0)));
        dataFromFile.remove(0);
        game.setPlayers(dataFromFile);
        GameHandlerStrategy gameHandlerStrategy = new GameHandlerStrategyImpl();
        gameHandlerStrategy.get(game.getGameName()).process(game);
    }
}
