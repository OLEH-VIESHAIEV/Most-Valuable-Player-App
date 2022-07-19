package model;

public class Team {
    private String name;
    private Integer countScore;

    public Team() {
    }

    public Team(String name, Integer countScore) {
        this.name = name;
        this.countScore = countScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountScore() {
        return countScore;
    }

    public void setCountScore(Integer countScore) {
        this.countScore = countScore;
    }

    @Override
    public String toString() {
        return "Team{"
                + "name='" + name + '\''
                + ", countScore=" + countScore
                + '}';
    }
}
