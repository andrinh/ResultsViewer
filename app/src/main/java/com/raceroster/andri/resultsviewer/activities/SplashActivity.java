package com.raceroster.andri.resultsviewer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.raceroster.andri.resultsviewer.R;
import com.raceroster.andri.resultsviewer.animationutilities.ActivityTransitionManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    protected void onStart() {
        super.onStart();
        int delayInMilliseconds = 2000;
        ActivityTransitionManager.proceedToActivityWithDelay(this, RacesActivity.class, delayInMilliseconds);
    }
}
