package back_devops.tp.tpback.model;

import java.util.List;

public class Driver {
    private String firstName;
    private String lastName;
    private String team;
    private int number;
    private int age;
    private String headshotUrl;
    private int wins;
    private int podiums;
    private int poles;
    private List<Achievement> achievements;

    public Driver() {}

    public Driver(String firstName, String lastName, String team, int number, int age, String headshotUrl,
                  int wins, int podiums, int poles, List<Achievement> achievements) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.number = number;
        this.age = age;
        this.headshotUrl = headshotUrl;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.achievements = achievements;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getHeadshotUrl() { return headshotUrl; }
    public void setHeadshotUrl(String headshotUrl) { this.headshotUrl = headshotUrl; }

    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }

    public int getPodiums() { return podiums; }
    public void setPodiums(int podiums) { this.podiums = podiums; }

    public int getPoles() { return poles; }
    public void setPoles(int poles) { this.poles = poles; }

    public List<Achievement> getAchievements() { return achievements; }
    public void setAchievements(List<Achievement> achievements) { this.achievements = achievements; }
}
