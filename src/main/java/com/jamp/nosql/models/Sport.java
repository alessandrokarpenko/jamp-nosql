package com.jamp.nosql.models;

public class Sport {

    private String name;
    private SportProficiency sportProficiency;

    public Sport(String name, SportProficiency sportProficiency) {
        this.name = name;
        this.sportProficiency = sportProficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SportProficiency getSportProficiency() {
        return sportProficiency;
    }

    public void setSportProficiency(SportProficiency sportProficiency) {
        this.sportProficiency = sportProficiency;
    }
}
