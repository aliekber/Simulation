package com.myprojects.ali.simulation;

import com.myprojects.ali.simulation.models.Poule;
import com.myprojects.ali.simulation.models.Team;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PoulUnitTest {

    @Test
    public void MakeNewPoul() {
        //Make new teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);
        Team chile = new Team("Chile", 90, 84);
        Team australia = new Team("Australia", 77, 75);

        //Make new arraylist with teams
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(netherlands);
        teams.add(spain);
        teams.add(chile);
        teams.add(australia);

        //make a new poule with the teams
        Poule poule = new Poule(teams);

        //Validate data
        assertEquals(poule.getPouleMatches().size(),6);
    }

    @Test
    public void sortPoule() throws Exception {
        //Make new teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team spain = new Team("Spain", 79, 78);
        Team chile = new Team("Chile", 90, 84);
        Team australia = new Team("Australia", 77, 75);

        //set team point score and conceded
        netherlands.setPoints(6);
        netherlands.setGoalsScored(5);
        netherlands.setGoalsAgainst(3);

        spain.setPoints(6);
        spain.setGoalsScored(5);
        spain.setGoalsAgainst(3);

        chile.setPoints(1);
        chile.setGoalsScored(1);
        chile.setGoalsAgainst(5);

        australia.setPoints(1);
        australia.setGoalsScored(1);
        australia.setGoalsAgainst(7);

        //make new poule
        ArrayList<Team> teams = new ArrayList<Team>();

        teams.add(australia);
        teams.add(netherlands);
        teams.add(chile);
        teams.add(spain);

        Poule poule = new Poule(teams);

        //sort the poule list with teams
        poule.sortPoule(poule.getPouleTeams());

        //get sorted data
        ArrayList<Team> sortedTeam = poule.getPouleTeams();

        Team position1 = sortedTeam.get(0);
        Team position2 = sortedTeam.get(1);
        Team position3 = sortedTeam.get(2);
        Team position4 = sortedTeam.get(3);

        //Validate data
        assertEquals(position1.getPoints(),6);
        assertEquals(position1.getGoalsScored(),5);
        assertEquals(position1.getGoalsAgainst(),3);

        assertEquals(position2.getPoints(),6);
        assertEquals(position2.getGoalsScored(),5);
        assertEquals(position2.getGoalsAgainst(),3);

        assertEquals(position3.getPoints(),1);
        assertEquals(position3.getGoalsScored(),1);
        assertEquals(position3.getGoalsAgainst(),5);

        assertEquals(position4.getPoints(),1);
        assertEquals(position4.getGoalsScored(),1);
        assertEquals(position4.getGoalsAgainst(),7);
    }
}
