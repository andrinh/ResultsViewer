package com.raceroster.andri.resultsviewer.animationutilities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import java.util.Arrays;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by andri on 2017-12-06.
 */

public class ActivityTransitionManager {

    public static void proceedToActivity(Activity previousActivity, Class<?> cls) {
        Intent i = new Intent(previousActivity, cls);
        startActivity(i, previousActivity);
    }

    public static void proceedToActivityWithDelay(final Activity previousActivity, final Class<?> classToGoTo, int delayInMilliseconds) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                proceedToActivity(previousActivity, classToGoTo);
                previousActivity.finish();
            }
        }, delayInMilliseconds);
    }

    public static void proceedToActivityAndClearStack(Activity previousActivity, Class<?> cls) {
        List<Integer> flags = Arrays.asList(FLAG_ACTIVITY_CLEAR_TOP, FLAG_ACTIVITY_CLEAR_TASK, FLAG_ACTIVITY_NEW_TASK);
        proceedToActivityWithFlags(previousActivity, cls, flags);
    }

    public static void proceedToActivityWithFlags(Activity previousActivity, Class<?> cls, List<Integer> flags) {
        Intent i = new Intent(previousActivity, cls);
        for (int flag : flags) {
            i.addFlags(flag);
        }
        startActivity(i, previousActivity);
    }

    private static void startActivity(Intent intent, Activity previousActivity) {
        previousActivity.startActivity(intent);
    }
}