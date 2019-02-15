package com.myprojects.ali.simulation.models;

public class Team {

    //the team object attributes
    private String teamName;
    private int attackStrength;
    private int defendingStrength;
    private int goalsScored;
    private int goalsAgainst;
    private int points;

    //constructor to make a new team with a attack and defending strength
    public Team(String teamName, int attackStrength, int defendingStrength) {
        this.teamName = teamName;
        this.attackStrength = attackStrength;
        this.defendingStrength = defendingStrength;
        this.points = 0;
        this.goalsAgainst = 0;
        this.goalsScored = 0;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getAttackStrength() {
        return this.attackStrength;
    }

    public int getDefendingStrength() {
        return this.defendingStrength;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int getGoalsAgainst() {
        return this.goalsAgainst;
    }

    public int getPoints() {
        return this.points;
    }

    public void setGoalsScored(int goals) {
        this.goalsScored += goals;
    }

    public void setGoalsAgainst(int goals) {
        this.goalsAgainst += goals;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    //reset the points and score to make a new simulation
    public void reset() {
        this.goalsScored = 0;
        this.goalsAgainst = 0;
        this.points = 0;
    }
}
