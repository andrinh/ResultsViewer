package com.raceroster.andri.resultsviewer.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.raceroster.andri.resultsviewer.models.Race;
import com.raceroster.andri.resultsviewer.R;

import java.util.List;

public class RaceRecyclerViewAdapter extends RecyclerView.Adapter<RaceViewHolder> {

    private Activity activity;
    private List<Race> races;

    public RaceRecyclerViewAdapter(Activity activity, List<Race> races) {
        this.activity = activity;
        this.races = races;
    }

    @Override
    public RaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.race_list_item, parent, false);
        return new RaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RaceViewHolder holder, int position) {
        Race race = races.get(position);
        holder.getNameView().setText(race.getName());
        setOnClickListener(holder, race);
    }

    @Override
    public int getItemCount() {
        return races.size();
    }

    private void setOnClickListener(final RaceViewHolder holder, final Race race) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.getNameView().getContext(), race.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

