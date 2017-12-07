package com.raceroster.andri.resultsviewer.listeners;

import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.animation.AlphaAnimation;

/**
 * Created by hunter on 2017-09-26.
 */

public class TitleOnOffsetChangedListener implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.2f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;
    private boolean isCollapsingTitleVisible = true;

    private View collapsingContent;

    public TitleOnOffsetChangedListener(View collapsingContent) {
        this.collapsingContent = collapsingContent;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
        handleTitleVisibility(percentage);
    }

    private void handleTitleVisibility(float percentage) {
        handleCollapsingTitleVisibility(percentage);
    }

    private void handleCollapsingTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(isCollapsingTitleVisible) {
                startAlphaAnimation(collapsingContent, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                isCollapsingTitleVisible = false;
            }
        } else {
            if (!isCollapsingTitleVisible) {
                startAlphaAnimation(collapsingContent, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                isCollapsingTitleVisible = true;
            }
        }
    }

    private void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
