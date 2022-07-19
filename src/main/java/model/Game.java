package model;

import java.util.Arrays;

public class Game {
    private GameName gameName;
    private Player player;

    public Game(GameName gameName, Player player) {
        this.gameName = gameName;
        this.player = player;
    }

    public GameName getGameName() {
        return gameName;
    }

    public void setGameName(GameName gameName) {
        this.gameName = gameName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public enum GameName {
        BASKETBALL,
        HANDBALL;

        private String gameName;

        GameName() {
        }

        GameName(String gameName) {
            this.gameName = gameName;
        }

        public String getGameName() {
            return gameName;
        }

        public static GameName getByName(String inputName) {
            return Arrays.stream(Game.GameName.values())
                    .filter(o -> o.getGameName().equals(inputName))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Unknown game name: " + inputName));
        }
    }

    @Override
    public String toString() {
        return "Game{"
                + "gameName=" + gameName
                + ", player=" + player
                + '}';
    }
}
