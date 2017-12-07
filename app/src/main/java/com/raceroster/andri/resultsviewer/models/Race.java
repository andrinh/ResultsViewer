package com.raceroster.andri.resultsviewer.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 2017-12-06.
 */

public class Race {

    private String name;
    private List<Result> results = new ArrayList<>();

    public Race(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Result> getResults() {
        return results;
    }
}
