package com.college.model;

public class Bike extends Vehicle {
    private boolean helmetStored;

    public Bike() {
        this("UNKNOWN", new Customer(), 0, false);
    }

    public Bike(String registrationNumber, Customer owner, int parkingHours, boolean helmetStored) {
        super(registrationNumber, VehicleType.BIKE, owner, parkingHours);
        this.helmetStored = helmetStored;
    }

    public boolean isHelmetStored() {
        return helmetStored;
    }

    public void setHelmetStored(boolean helmetStored) {
        this.helmetStored = helmetStored;
    }

    @Override
    public double getBaseRate() {
        return 20.0;
    }
}
