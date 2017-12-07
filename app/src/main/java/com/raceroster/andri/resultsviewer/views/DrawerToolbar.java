package com.raceroster.andri.resultsviewer.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import com.raceroster.andri.resultsviewer.R;

/**
 * Created by hunter on 2017-09-12.
 */

public class DrawerToolbar extends Toolbar {

    private ImageButton menuButton;

    public DrawerToolbar(Context context) {
        super(context);
        initView();
    }

    public DrawerToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawerToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.drawer_toolbar_layout, this);
        this.menuButton = findViewById(R.id.menu_button_left);
    }

    public void initMenuButtonClickListener(DrawerLayout drawer) {
        menuButton.setOnClickListener(createDrawerButtonClickListener(drawer));
    }

    private View.OnClickListener createDrawerButtonClickListener(final DrawerLayout drawer) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        };
    }
}
