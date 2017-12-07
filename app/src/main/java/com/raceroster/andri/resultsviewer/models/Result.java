package com.raceroster.andri.resultsviewer.models;


/**
 * Created by andri on 2017-12-06.
 */

public class Result {

    private String participantName;
    private float time;

    public Result(String participantName, float time) {
        this.participantName = participantName;
        this.time = time;
    }
}
