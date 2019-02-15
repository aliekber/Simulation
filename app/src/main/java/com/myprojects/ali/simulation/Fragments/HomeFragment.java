package com.myprojects.ali.simulation.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.myprojects.ali.simulation.Adapters.OverviewListAdapter;
import com.myprojects.ali.simulation.Adapters.ResultsListAdapter;
import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.*;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private Poule poule;
    private boolean results = false;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //make the new teams
        Team netherlands = new Team("Netherlands", 85, 85);
        Team Spain = new Team("Spain", 79, 78);
        Team Chile = new Team("Chile", 90, 84);
        Team Australia = new Team("Australia", 77, 75);

        //add the teams in a array and make the poule
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(netherlands);
        teams.add(Spain);
        teams.add(Chile);
        teams.add(Australia);

        poule = new Poule(teams);

        //get the listview and make fill it with the teams
        final ListView listView = (ListView) view.findViewById(R.id.teamlist);

        OverviewListAdapter adapter = new OverviewListAdapter(this.getContext(), R.layout.list_item_overview, teams);

        listView.setAdapter(adapter);

        //get the buttons on the screen
        final Button simulateButton = (Button) view.findViewById(R.id.simulateButton);
        final Button resultsButton = (Button) view.findViewById(R.id.resultsButton);

        //if the simulate button is pressed simulate the game and set the new listview with data
        simulateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                poule.resetPoule();
                poule.simulatePoule();
                ArrayList<Team> sortedTeams = poule.sortPoule(poule.getPouleTeams());
                OverviewListAdapter playedGames = new OverviewListAdapter(v.getContext(), R.layout.list_item_overview, sortedTeams);
                listView.setAdapter(playedGames);
            }
        });

        //if the results button is pressed show the match scores in the listview and hide the textviews
        resultsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView rank = (TextView) getView().findViewById(R.id.rank);
                TextView team = (TextView) getView().findViewById(R.id.team);
                TextView outGoals = (TextView) getView().findViewById(R.id.outGoals);
                TextView homeGoals = (TextView) getView().findViewById(R.id.homeGoals);
                TextView point = (TextView) getView().findViewById(R.id.point);

                //if the results is not on the screen and the button is clicked hide the textviews and show the scores in the list
                //if the results on the screen and de button is clicked than show the textviews and de overview
                if(results == false){
                    rank.setVisibility(View.INVISIBLE);
                    team.setVisibility(View.INVISIBLE);
                    outGoals.setVisibility(View.INVISIBLE);
                    homeGoals.setVisibility(View.INVISIBLE);
                    point.setVisibility(View.INVISIBLE);

                    resultsButton.setText("Back");
                    simulateButton.setEnabled(false);

                    ResultsListAdapter adapter = new ResultsListAdapter(v.getContext(), R.layout.list_item_result, poule.getPouleMatches());
                    listView.setAdapter(adapter);
                    results = true;
                } else{
                    rank.setVisibility(View.VISIBLE);
                    team.setVisibility(View.VISIBLE);
                    outGoals.setVisibility(View.VISIBLE);
                    homeGoals.setVisibility(View.VISIBLE);
                    point.setVisibility(View.VISIBLE);

                    resultsButton.setText("Results");
                    simulateButton.setEnabled(true);

                    ArrayList<Team> sortedTeams = poule.sortPoule(poule.getPouleTeams());
                    OverviewListAdapter playedGames = new OverviewListAdapter(v.getContext(), R.layout.list_item_overview, sortedTeams);
                    listView.setAdapter(playedGames);
                    results = false;
                }

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
