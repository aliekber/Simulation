package com.myprojects.ali.simulation;

import com.myprojects.ali.simulation.models.Match;
import com.myprojects.ali.simulation.models.Team;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamUnitTest {

    @Test
    public void makeNewTeam() {
        //Home team data
        String homeTeamName = "Netherlands";
        int homeTeamAttackingStrength = 85;
        int homeTeamDefendingStrength = 85;

        //Home team data
        String outTeamName = "Spain";
        int outTeamAttackingStrength = 79;
        int outTeamDefendingStrength = 78;;

        //Make the home and out teams
        Team netherlands = new Team(homeTeamName, homeTeamAttackingStrength, homeTeamDefendingStrength);
        Team spain = new Team(outTeamName,outTeamAttackingStrength,outTeamDefendingStrength);

        //Validate data
        assertEquals(netherlands.getTeamName(), homeTeamName);
        assertEquals(netherlands.getAttackStrength(), homeTeamAttackingStrength);
        assertEquals(netherlands.getDefendingStrength(), homeTeamDefendingStrength);
        assertEquals(spain.getTeamName(), outTeamName);
        assertEquals(spain.getAttackStrength(), outTeamAttackingStrength);
        assertEquals(spain.getDefendingStrength(), outTeamDefendingStrength);
    }

    @Test
    public void ResetTeam() {
        //Home team data
        String homeTeamName = "Netherlands";
        int homeTeamAttackingStrength = 85;
        int homeTeamDefendingStrength = 85;

        //Home team data
        String outTeamName = "Spain";
        int outTeamAttackingStrength = 79;
        int outTeamDefendingStrength = 78;;

        //Make the home and out teams
        Team netherlands = new Team(homeTeamName, homeTeamAttackingStrength, homeTeamDefendingStrength);
        Team spain = new Team(outTeamName,outTeamAttackingStrength,outTeamDefendingStrength);

        //Make the match
        Match match = new Match(netherlands, spain);

        //Simulate the match
        match.simulateMatch();

        //Reset the teams
        netherlands.reset();
        spain.reset();

        //check point earned
        assertEquals(netherlands.getPoints(), 0);
        assertEquals(spain.getPoints(), 0);

        //check scored goals
        assertEquals(netherlands.getGoalsScored(), 0);
        assertEquals(spain.getGoalsScored(), 0);

        //check condeded goals
        assertEquals(netherlands.getGoalsAgainst(), 0);
        assertEquals(spain.getGoalsAgainst(), 0);
    }

}
