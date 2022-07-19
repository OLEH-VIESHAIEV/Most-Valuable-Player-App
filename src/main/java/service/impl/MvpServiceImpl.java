package service.impl;

import db.Storage;
import java.util.Map;
import model.Player;
import service.MvpService;

public class MvpServiceImpl implements MvpService {
    private Player mvp;
    private Integer summaryRatingPoints = 0;

    @Override
    public Player getMvp() {
        for (Map.Entry<Player, Integer> players : Storage.playerStorage.entrySet()) {
            if (players.getValue() > summaryRatingPoints) {
                mvp = players.getKey();
                summaryRatingPoints = players.getValue();
            }
        }
        return mvp;
    }
}
