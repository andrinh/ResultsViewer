package com.raceroster.andri.resultsviewer.utils.applications;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by rhinodesktop on 2017-02-02.
 */

public class ResultsViewerApp extends MultiDexApplication {

    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        //TODO: custom app logic
    }
}
