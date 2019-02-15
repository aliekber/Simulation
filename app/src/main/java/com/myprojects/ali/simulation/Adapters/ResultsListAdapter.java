package com.myprojects.ali.simulation.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.Match;

import java.util.ArrayList;

public class ResultsListAdapter extends ArrayAdapter<Match> {

    private Context context;
    int resource;

    public ResultsListAdapter(Context context, int resource, ArrayList< Match > matches) {
        super(context, resource, matches);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //make all data
        String homeTeamName = getItem(position).getHomeTeam().getTeamName();
        String homeTeamGoals = String.valueOf(getItem(position).getHomeGoals());
        String outTeamGoals = String.valueOf(getItem(position).getOutGoals());
        String OutTeamName = getItem(position).getAwayTeam().getTeamName();
        //get the view
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);
        //get all textviews from the view
        TextView homeTeam = convertView.findViewById(R.id.homeTeam);
        TextView homeGoals = convertView.findViewById(R.id.homeGoals);
        TextView outGoals = convertView.findViewById(R.id.outGoals);
        TextView OutTeam = convertView.findViewById(R.id.outTeam);

        //set all data in the textviews
        homeTeam.setText(homeTeamName);
        homeGoals.setText(homeTeamGoals);
        outGoals.setText(outTeamGoals);
        OutTeam.setText(OutTeamName);

        return convertView;
    }
}
