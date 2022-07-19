package service;

import model.Game;
import strategy.GameHandler;

public interface GameHandlerStrategy {
    GameHandler get(Game.GameName gameName);
}
