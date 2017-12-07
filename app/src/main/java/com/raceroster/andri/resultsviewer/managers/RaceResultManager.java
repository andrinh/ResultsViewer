package com.raceroster.andri.resultsviewer.managers;

import com.raceroster.andri.resultsviewer.models.Race;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 2017-12-06.
 */

public class RaceResultManager {

    private static RaceResultManager raceResultManager;

    private List<Race> races = new ArrayList<>();

    public static RaceResultManager getInstance() {
        if (raceResultManager == null) {
            raceResultManager = new RaceResultManager();
        }
        return raceResultManager;
    }

    public List<Race> getRaces() {
        return races;
    }

    private RaceResultManager() {
        populateRacesWithResults();
    }

    //Create dummy data for the app
    private void populateRacesWithResults() {
        races.add(new Race("Fun Run 5k"));
        races.add(new Race("1500m Night"));
        races.add(new Race("Toronto Marathon"));
        races.add(new Race("Downtown Road 800m"));
        races.add(new Race("Ultra Marathon"));
        races.add(new Race("National Track and Field Championship"));
        races.add(new Race("International Track and Field Championship"));
        races.add(new Race("Intergalactic Track and Field Championship"));
        races.add(new Race("Other event"));
        races.add(new Race("Other event again"));
        races.add(new Race("Other event and again"));

    }
}
