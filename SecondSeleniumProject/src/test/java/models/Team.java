package models;

public class Team {
    private String teamName;
    private String teamDescr;

    public Team(String teamName, String teamDescr) {
        this.teamName = teamName;
        this.teamDescr = teamDescr;
    }

    public Team() {}

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team setTeamDescr(String teamDescr) {
        this.teamDescr = teamDescr;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDescr() {
        return teamDescr;
    }
}
