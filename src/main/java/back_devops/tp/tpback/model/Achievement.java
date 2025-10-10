package back_devops.tp.tpback.model;

public class Achievement {
    private int year;
    private String race;
    private String result;
    private String description;

    public Achievement() {}

    public Achievement(int year, String race, String result, String description) {
        this.year = year;
        this.race = race;
        this.result = result;
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
