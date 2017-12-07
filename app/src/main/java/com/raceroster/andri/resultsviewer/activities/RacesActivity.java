package com.raceroster.andri.resultsviewer.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.raceroster.andri.resultsviewer.R;
import com.raceroster.andri.resultsviewer.adapters.RaceRecyclerViewAdapter;
import com.raceroster.andri.resultsviewer.listeners.TitleOnOffsetChangedListener;
import com.raceroster.andri.resultsviewer.managers.RaceResultManager;
import com.raceroster.andri.resultsviewer.utils.RecyclerViewUtils;

import org.greenrobot.eventbus.EventBus;

public class RacesActivity extends DrawerAppBarActivity {

    private RaceRecyclerViewAdapter racesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_races);
        initViews();
    }

    private void initViews() {
        initRecyclerView();
        initToolbar();
    }

    private void initRecyclerView() {
        RecyclerView racesRecyclerView = findViewById(R.id.recyclerview_items);
        racesAdapter = new RaceRecyclerViewAdapter(this, RaceResultManager.getInstance().getRaces());
        RecyclerViewUtils.initVerticalRecyclerView(this, racesRecyclerView, racesAdapter);
    }

    private void initToolbar() {
        initNavigationBar();
        initToolbarTitleOffsetListener();
    }

    private void initToolbarTitleOffsetListener() {
        View collapsingContentView = findViewById(R.id.textview_collapsing_text);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = new TitleOnOffsetChangedListener(collapsingContentView);
        appBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
    }
}
