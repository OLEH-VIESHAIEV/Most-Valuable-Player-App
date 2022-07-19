package strategy;

import db.Storage;
import java.util.List;
import model.Game;
import model.Player;
import model.Team;
import validator.HandballFormatValidator;

public class HandBallHandler implements GameHandler {
    private static final int NAME_INDEX = 0;
    private static final int NICK_NAME_INDEX = 1;
    private static final int NUMBER_INDEX = 2;
    private static final int TEAM_NAME_INDEX = 3;
    private static final int GOAL_MADE_INDEX = 4;
    private static final int GOAL_RECEIVED_INDEX = 5;

    @Override
    public void process(Game game) {
        List<String> players = game.getPlayers();
        HandballFormatValidator.validate(players);
        Team teamWinner = findWinnerTeam(players);
        for (int i = 1; i < players.size(); i++) {
            String line = players.get(i);
            String[] records = line.split(";");
            Player player = new Player(records[NAME_INDEX], records[NICK_NAME_INDEX],
                    Integer.parseInt(records[NUMBER_INDEX]), records[TEAM_NAME_INDEX]);
            Integer initialRatingPoints = Storage.playerStorage.get(player);
            Storage.playerStorage.put(player, initialRatingPoints == null
                    ? records[TEAM_NAME_INDEX].equals(teamWinner.getName())
                            ? calculateRatingPoints(records) + 10
                            : calculateRatingPoints(records) :
                    records[TEAM_NAME_INDEX].equals(teamWinner.getName())
                            ? initialRatingPoints + calculateRatingPoints(records) + 10
                            : calculateRatingPoints(records));
        }
    }

    private Integer calculateRatingPoints(String[] records) {
        return Integer.parseInt(records[GOAL_MADE_INDEX]) * 2
                - Integer.parseInt(records[GOAL_RECEIVED_INDEX]);
    }

    private Team findWinnerTeam(List<String> players) {
        Team teamA = new Team();
        Integer teamACountScore = 0;
        Team teamB = new Team();
        Integer teamBCountScore = 0;
        for (int i = 1; i < players.size(); i++) {
            String line = players.get(i);
            String[] records = line.split(";");
            if (teamA.getName() == null) {
                teamA.setName(records[3]);
            } else if (!records[3].equals(teamA.getName()) && teamB.getName() == null) {
                teamB.setName(records[3]);
            }
            if (records[3].equals(teamA.getName())) {
                teamACountScore += Integer.parseInt(records[4]) * 2
                        - Integer.parseInt(records[5]);
            } else {
                teamBCountScore += Integer.parseInt(records[4]) * 2
                        - Integer.parseInt(records[5]);
            }
        }
        teamA.setCountScore(teamACountScore);
        teamB.setCountScore(teamBCountScore);
        return teamA.getCountScore() > teamB.getCountScore() ? teamA : teamB;
    }
}
