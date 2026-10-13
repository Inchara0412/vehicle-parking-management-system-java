package com.college.model;

public class Truck extends Vehicle {
    private double loadTons;

    public Truck() {
        this("UNKNOWN", new Customer(), 0, 0.0);
    }

    public Truck(String registrationNumber, Customer owner, int parkingHours, double loadTons) {
        super(registrationNumber, VehicleType.TRUCK, owner, parkingHours);
        this.loadTons = loadTons;
    }

    public double getLoadTons() {
        return loadTons;
    }

    public void setLoadTons(double loadTons) {
        this.loadTons = loadTons;
    }

    @Override
    public double getBaseRate() {
        return 80.0;
    }
}
