package com.myprojects.ali.simulation.models;

import java.util.ArrayList;

public class Poule {

    //the teams and all matches in a poul
    private ArrayList<Team> pouleTeams;
    private ArrayList<Match> pouleMatches;


    //make a new poule with the teams
    public Poule(ArrayList<Team> teams) {
        this.pouleTeams = teams;
        pouleMatches = new ArrayList<Match>();

        initPouleGames();
    }

    //init all games in a poule
    private void initPouleGames() {
        //make all matches for the poule without itself
        for (int i = 0; i < pouleTeams.size(); i++) {
            for (int ii = 0; ii < pouleTeams.size(); ii++) {
                if (ii != i && i < ii) {
                    Match pouleGame = new Match(pouleTeams.get(i), pouleTeams.get(ii));
                    this.pouleMatches.add(pouleGame);
                }
            }
        }
    }

    //simulate all matches in the poule
    public void simulatePoule() {
        for (Match match : pouleMatches) {
            match.simulateMatch();
        }
    }

    //reset all teams in the poule
    public void resetPoule() {
        for (Team t : pouleTeams) {
            t.reset();
        }
        pouleMatches.clear();
        initPouleGames();
    }

    //sort the array when the poule is simulated
    public ArrayList<Team> sortPoule(ArrayList<Team> foundTeams) {
        ArrayList<Team> sortedTeams = new ArrayList<Team>(foundTeams);
        for (int i = 0; i < foundTeams.size(); i++) {
            for (int ii = 0; ii < foundTeams.size(); ii++) {
                //compare the team points
                if (CheckPointDifference(foundTeams.get(i), sortedTeams.get(ii))) {
                    sortedTeams.remove(foundTeams.get(i));
                    sortedTeams.add(ii, foundTeams.get(i));
                }
            }
        }
        this.pouleTeams = sortedTeams;
        return sortedTeams;
    }

    //check the points from the teams to sort the list if the points are the same then check the goals
    private Boolean CheckPointDifference(Team homeTeam, Team awayTeam) {
        if (homeTeam.getPoints() < awayTeam.getPoints()) {
            return true;
        }
        if (homeTeam.getPoints() == awayTeam.getPoints()) {
            //see which team has a better goal difference
            return CheckGoalDifference(homeTeam, awayTeam);
        } else {
            return false;
        }
    }

    //if the points are the same than check which team has a better goal difference
    private Boolean CheckGoalDifference(Team homeTeam, Team awayTeam) {
        int homeTeamGoalDifference = homeTeam.getGoalsScored() - homeTeam.getGoalsAgainst();
        int awayTeamGoalDifference = awayTeam.getGoalsScored() - awayTeam.getGoalsAgainst();

        if (homeTeamGoalDifference < awayTeamGoalDifference) {
            return true;
        } else if (homeTeamGoalDifference == awayTeamGoalDifference) {
            //if the goal difference are the same then check which team has more goals scored
            return CheckHomeGoalDifference(homeTeam, awayTeam);
        } else {
            return false;
        }

    }

    //check witch team has more goals scored
    private boolean CheckHomeGoalDifference(Team homeTeam, Team awayTeam) {
        int homeTeamScoredGoals = homeTeam.getGoalsScored();
        int awayTeamScoredGoals = awayTeam.getGoalsScored();
        if (homeTeamScoredGoals < awayTeamScoredGoals) {
            return true;
        } else if (homeTeamScoredGoals == awayTeamScoredGoals) {
            return CheckMutualResult(homeTeam, awayTeam);
        } else {
            return false;
        }
    }

    //check the result from the mutual game
    private Boolean CheckMutualResult(Team homeTeam, Team awayTeam) {
        //check all poule games to get the mutual games from the teams
        for (Match pouleGame : pouleMatches) {
            if (pouleGame.getHomeTeam().equals(homeTeam) && pouleGame.getAwayTeam().equals(awayTeam)) {
                if (pouleGame.getHomeGoals() < pouleGame.getOutGoals()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<Team> getPouleTeams() {
        return pouleTeams;
    }

    public ArrayList<Match> getPouleMatches() {
        return pouleMatches;
    }

}
