package model;

import java.util.Objects;

public class Player {
    private String name;
    private String nickName;
    private Integer number;
    private String team;
    private Integer ratingPoints;

    public Player(String name, String nickName, Integer number,
                  String team, Integer ratingPoints) {
        this.name = name;
        this.nickName = nickName;
        this.number = number;
        this.team = team;
        this.ratingPoints = ratingPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getRatingPoints() {
        return ratingPoints;
    }

    public void setRatingPoints(Integer ratingPoints) {
        this.ratingPoints = ratingPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name)
                && Objects.equals(nickName, player.nickName)
                && Objects.equals(number, player.number)
                && Objects.equals(team, player.team)
                && Objects.equals(ratingPoints, player.ratingPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickName, number, team, ratingPoints);
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", nickName='" + nickName + '\''
                + ", number=" + number
                + ", team='" + team + '\''
                + ", ratingPoints=" + ratingPoints
                + '}';
    }
}
