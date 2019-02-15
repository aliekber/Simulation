package com.myprojects.ali.simulation.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.Team;

import java.util.ArrayList;

public class OverviewListAdapter extends ArrayAdapter<Team> {

    private Context context;
    int resource;

    public OverviewListAdapter(Context context, int resource, ArrayList< Team > teams) {
        super(context, resource, teams);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //make all data
        String Rank = position + 1 + "";
        String name = getItem(position).getTeamName();
        String points = String.valueOf(getItem(position).getPoints());
        String GoalsScored = String.valueOf(getItem(position).getGoalsScored());
        String GoalsConceded = String.valueOf(getItem(position).getGoalsAgainst());
        //get the view
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);
        //get all textviews from the view
        TextView rank = convertView.findViewById(R.id.rank);
        TextView teamName = convertView.findViewById(R.id.team);
        TextView Points = convertView.findViewById(R.id.points);
        TextView Goals = convertView.findViewById(R.id.Scored);
        TextView Conceded = convertView.findViewById(R.id.Conceded);

        //set all textviews witch the data
        rank.setText(Rank);
        teamName.setText(name);
        Points.setText(points);
        Goals.setText(GoalsScored);
        Conceded.setText(GoalsConceded);

        return convertView;
    }
}
