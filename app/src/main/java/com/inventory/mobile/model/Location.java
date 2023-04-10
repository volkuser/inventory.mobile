package com.inventory.mobile.model;

public class Location {
    private Long locationId;
    private String locationNumber;
    private TrainingCenter trainingCenter;

    public String getLocationNumber() {
        return locationNumber;
    }

    public TrainingCenter getTrainingCenter() {
        return trainingCenter;
    }
}
