package com.example.moody;

public class Data {
    private float happiness;
    private float rest;

    public Data(float happiness, float rest) {
        this.happiness = happiness;
        this.rest = rest;
    }

    public float getHappiness() {
        return happiness;
    }

    public void setHappiness(float happiness) {
        this.happiness = happiness;
    }

    public float getRest() {
        return rest;
    }

    public void setRest(float rest) {
        this.rest = rest;
    }
}
