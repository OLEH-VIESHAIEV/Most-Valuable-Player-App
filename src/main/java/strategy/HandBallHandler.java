package strategy;

import db.Storage;
import model.Game;

public class HandBallHandler implements GameHandler {
    @Override
    public void process(Game game) {
        Integer initialRatingPoints = Storage.playerStorage.get(game.getPlayer());
        Storage.playerStorage.put(game.getPlayer(), initialRatingPoints == null
                ? game.getPlayer().getRatingPoints() : initialRatingPoints
                + game.getPlayer().getRatingPoints());
    }
}
