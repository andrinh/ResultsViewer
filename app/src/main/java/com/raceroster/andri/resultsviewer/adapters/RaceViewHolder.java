package com.raceroster.andri.resultsviewer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raceroster.andri.resultsviewer.R;

/**
 * Created by hunter on 2017-09-22.
 */

public class RaceViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameView;

    public RaceViewHolder(View view) {
        super(view);
        nameView = itemView.findViewById(R.id.textview_race_name);
    }

    public TextView getNameView() {
        return nameView;
    }
}