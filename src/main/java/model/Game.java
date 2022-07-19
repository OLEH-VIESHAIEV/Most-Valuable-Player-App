package model;

import java.util.Arrays;
import java.util.List;

public class Game {
    private GameName gameName;
    private List<String> players;

    public Game() {
    }

    public Game(GameName gameName, List<String> players) {
        this.gameName = gameName;
        this.players = players;
    }

    public GameName getGameName() {
        return gameName;
    }

    public void setGameName(GameName gameName) {
        this.gameName = gameName;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
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
                + ", players=" + players
                + '}';
    }
}
