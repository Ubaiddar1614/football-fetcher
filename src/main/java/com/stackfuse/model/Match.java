package com.stackfuse.model;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private String date;
    private String matchStatus;

    public Match(String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals, String date, String matchStatus) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        this.matchStatus = matchStatus;
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public String getMatchStatus() {
        return matchStatus;
    }
    public String getDate() {
        return date;
    }
}
