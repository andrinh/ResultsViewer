package com.raceroster.andri.resultsviewer.activities;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.LinearLayout;

import com.raceroster.andri.resultsviewer.R;
import com.raceroster.andri.resultsviewer.animationutilities.ActivityTransitionManager;
import com.raceroster.andri.resultsviewer.views.DrawerToolbar;

/**
 * Created by rhinodesktop on 2017-02-17.
 */

public abstract class DrawerAppBarActivity extends AnimateBackPressActivity {

    private DrawerToolbar drawerToolbar;
    private DrawerLayout drawer;

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    protected void initNavigationBar() {
        drawerToolbar = findViewById(R.id.standard_toolbar);
        setSupportActionBar(drawerToolbar);
        drawer = findViewById(R.id.drawer_layout);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, drawerToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
        toggle.syncState();
        drawer.addDrawerListener(toggle);
        drawerToolbar.initMenuButtonClickListener(drawer);
        initNavButtons();
    }

    private void initNavButtons() {
        LinearLayout homeButtonLayout = findViewById(R.id.llayout_home_option);
        setOnClickListenerForButton(homeButtonLayout, RacesActivity.class);

        initLogoutButton();
    }

    private void setOnClickListenerForButton(LinearLayout layout, final Class<?> classToGoTo) {
        final Activity currentActivity = this;
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Don't navigate to the same activity.
                if (currentActivity.getClass().equals(classToGoTo)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    handleActivityTransition(currentActivity, classToGoTo);
                }
            }
        });
    }

    private void handleActivityTransition(Activity currentActivity, Class<?> classToGoTo) {
        if (classToGoTo.equals(RacesActivity.class)) {
            ActivityTransitionManager.proceedToActivityAndClearStack(currentActivity, classToGoTo);
        } else {
//            TODO:
        }
    }

    private void initLogoutButton() {
        //TODO
    }
}
