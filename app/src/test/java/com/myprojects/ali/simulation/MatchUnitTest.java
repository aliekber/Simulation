package com.myprojects.ali.simulation;

import com.myprojects.ali.simulation.models.Match;
import com.myprojects.ali.simulation.models.Team;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchUnitTest {

    @Test
    public void makeNewMatch() {
        //make teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);

        //make new match and give home and out teams
        Match match = new Match(netherlands, spain);

        //validate data
        assertEquals(match.getHomeTeam(), netherlands);
        assertEquals(match.getAwayTeam(), spain);
    }

    @Test
    public void SimulatewMatch() {
        //make teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);

        //make new match and give home and out teams
        Match match = new Match(netherlands, spain);

        //validate match is not played
        assertEquals(match.isPlayed(), false);

        //simulate the match
        match.simulateMatch();

        //validate match is played
        assertEquals(match.isPlayed(), true);
    }

    @Test
    public void MatchPoints() {
        //make teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);

        //make new match and give home and out teams
        Match match = new Match(netherlands, spain);

        //simulate the match
        match.simulateMatch();

        //Calculate points
        int homePoints;
        int outPoints;

        if(match.getHomeGoals() < match.getOutGoals()){
            homePoints = 0;
            outPoints = 3;
        }else if(match.getHomeGoals()> match.getOutGoals()){
            homePoints = 3;
            outPoints = 0;
        }else {
            homePoints = 1;
            outPoints = 1;
        }

        //validate data
        assertEquals(netherlands.getPoints(), homePoints);
        assertEquals(spain.getPoints(), outPoints);
    }

    @Test
    public void MatchGoals() {
        //make teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);

        //make new match and give home and out teams
        Match match = new Match(netherlands, spain);

        //simulate the match
        match.simulateMatch();

        assertEquals(netherlands.getGoalsScored(), match.getHomeGoals());
        assertEquals(spain.getGoalsScored(), match.getOutGoals());
    }

}
