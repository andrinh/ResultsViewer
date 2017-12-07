package com.raceroster.andri.resultsviewer.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by hunter on 2017-09-22.
 */

public class RecyclerViewUtils {

    public static void initVerticalRecyclerView(Context context, RecyclerView recyclerView,
                                                RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        LinearLayoutManager layoutManager = createLayoutManager(context, false, false);
        setRecyclerView(recyclerView, layoutManager, adapter);
    }

    private static LinearLayoutManager createLayoutManager(Context context, boolean reverseLayout, boolean stackFromEnd) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(reverseLayout);
        layoutManager.setStackFromEnd(stackFromEnd);
        return layoutManager;
    }

    private static void setRecyclerView(RecyclerView recyclerView, LinearLayoutManager layoutManager,
                                        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
