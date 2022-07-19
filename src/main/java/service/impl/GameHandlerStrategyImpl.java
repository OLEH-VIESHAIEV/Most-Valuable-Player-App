package service.impl;

import java.util.HashMap;
import java.util.Map;
import model.Game;
import service.GameHandlerStrategy;
import strategy.BasketBallHandler;
import strategy.GameHandler;
import strategy.HandBallHandler;

public class GameHandlerStrategyImpl implements GameHandlerStrategy {
    private Map<Game.GameName, GameHandler> map = new HashMap<>();

    {
        map.put(Game.GameName.BASKETBALL, new BasketBallHandler());
        map.put(Game.GameName.HANDBALL, new HandBallHandler());
    }

    @Override
    public GameHandler get(Game.GameName gameName) {
        return map.get(gameName);
    }
}
