package com.myprojects.ali.simulation.models;

import java.util.Random;

public class Match{

    //max reel goals that a team can score
    private static final int MAXGOALS = 3;

    //the points for win dwar and loss matches
    private static final int WIN = 3;
    private static final int DRAW = 1;
    private static final int LOSS = 0;

    //the teams in a match
    private Team homeTeam;
    private Team outTeam;

    //the goals in a match
    private int homeGoals;
    private int outGoals;

    //check is the match played
    private boolean played;

    public Match(Team homeTeam, Team outTeam) {

        this.homeTeam = homeTeam;
        this.outTeam = outTeam;
        this.homeGoals = 0;
        this.outGoals = 0;
        this.played = false;

    }

    //simulate the match
    public void simulateMatch() {

        //calculate goals for teams;
        int maxHomeGoals = calculateGoals(homeTeam, outTeam);
        int maxOutGoals = calculateGoals(outTeam, homeTeam);

        //create a Random object to generate a random integers
        Random random = new Random();

        //Set score for the match base on the calculated goals
        this.homeGoals = random.nextInt(maxHomeGoals);
        this.outGoals = random.nextInt(maxOutGoals);
        this.homeTeam.setGoalsAgainst(this.outGoals);
        this.homeTeam.setGoalsScored(this.homeGoals);
        this.outTeam.setGoalsAgainst(this.homeGoals);
        this.outTeam.setGoalsScored(this.outGoals);

        //set the played ckeck to true
        this.played = true;

        //set the points to the teams
        this.addPointsToTeam();
    }

    //calculate the goals for a team
    private int calculateGoals(Team team1, Team team2) {
        //compare the team 1 attack strength to the team 2 defending strength and gif the max goals
        if (team1.getAttackStrength() > team2.getDefendingStrength()) {
            return MAXGOALS + MAXGOALS;
        } else {
            return MAXGOALS;
        }
    }

    //add the points to the teams after simulation
    private void addPointsToTeam() {
        if (homeGoals > outGoals) {
            homeTeam.setPoints(WIN);
            outTeam.setPoints(LOSS);
        } else if (homeGoals < outGoals) {
            homeTeam.setPoints(LOSS);
            outTeam.setPoints(WIN);
        } else {
            homeTeam.setPoints(DRAW);
            outTeam.setPoints(DRAW);
        }
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public Team getAwayTeam() {
        return this.outTeam;
    }

    public int getHomeGoals() {
        return this.homeGoals;
    }

    public int getOutGoals() {
        return this.outGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setOutGoals(int outGoals) {
        this.outGoals = outGoals;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public boolean isPlayed() {
        return this.played;
    }
}
