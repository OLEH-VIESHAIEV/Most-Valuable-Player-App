package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Game;
import model.Player;
import model.Team;
import service.ParseDataService;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int NAME_INDEX = 0;
    private static final int NICK_NAME_INDEX = 1;
    private static final int NUMBER_INDEX = 2;
    private static final int TEAM_NAME_INDEX = 3;
    private static final int SCORED_POINTS_INDEX = 4;
    private static final int REBOUND_INDEX = 5;
    private static final int ASSIST_INDEX = 6;
    private static final int GOAL_MADE_INDEX = 4;
    private static final int GOAL_RECEIVED_INDEX = 5;

    @Override
    public List<Game> parse(List<String> dataFromFile) {
        List<Game> games = new ArrayList<>();
        Team teamWinner = findWinnerTeam(dataFromFile);
        for (int i = 1; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            String[] records = line.split(";");
            if (dataFromFile.get(0).equals(Game.GameName.BASKETBALL.toString())) {
                games.add(new Game(Game.GameName.BASKETBALL,
                        new Player(records[NAME_INDEX], records[NICK_NAME_INDEX],
                                Integer.parseInt(records[NUMBER_INDEX]), records[TEAM_NAME_INDEX],
                                records[TEAM_NAME_INDEX].equals(teamWinner.getName())
                                        ? Integer.parseInt(records[SCORED_POINTS_INDEX]) + 10
                                        : Integer.parseInt(records[SCORED_POINTS_INDEX])
                                + Integer.parseInt(records[REBOUND_INDEX])
                                + Integer.parseInt(records[ASSIST_INDEX]))));

            } else if (dataFromFile.get(0).equals(Game.GameName.HANDBALL.toString())) {
                games.add(new Game(Game.GameName.HANDBALL,
                        new Player(records[NAME_INDEX], records[NICK_NAME_INDEX],
                                Integer.parseInt(records[NUMBER_INDEX]), records[TEAM_NAME_INDEX],
                                records[TEAM_NAME_INDEX].equals(teamWinner.getName())
                                        ? Integer.parseInt(records[GOAL_MADE_INDEX]) + 10
                                        : Integer.parseInt(records[GOAL_MADE_INDEX])
                                - Integer.parseInt(records[GOAL_RECEIVED_INDEX]))));
            }
        }
        return games;
    }

    private Team findWinnerTeam(List<String> dataFromFile) {
        Team teamA = new Team();
        Integer teamACountScore = 0;
        Team teamB = new Team();
        Integer teamBCountScore = 0;
        for (int i = 1; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            String[] records = line.split(";");
            if (teamA.getName() == null) {
                teamA.setName(records[3]);
            } else if (!records[3].equals(teamA.getName()) && teamB.getName() == null) {
                teamB.setName(records[3]);
            }
            if (records[3].equals(teamA.getName())) {
                teamACountScore += Integer.parseInt(records[4]);
            } else {
                teamBCountScore += Integer.parseInt(records[4]);
            }
        }
        teamA.setCountScore(teamACountScore);
        teamB.setCountScore(teamBCountScore);
        return teamA.getCountScore() > teamB.getCountScore() ? teamA : teamB;
    }
}
