package back_devops.tp.tpback.model;

import java.util.List;

public class Driver {
    private String name;
    private int wins;
    private int podiums;
    private int poles;
    private List<Achievement> achievements;

    public Driver() {}

    public Driver(String name, int wins, int podiums, int poles, List<Achievement> achievements) {
        this.name = name;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
}
