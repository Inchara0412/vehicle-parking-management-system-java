package com.college.model;

public class Car extends Vehicle {
    private int seats;

    public Car() {
        this("UNKNOWN", new Customer(), 0, 4);
    }

    public Car(String registrationNumber, Customer owner, int parkingHours, int seats) {
        super(registrationNumber, VehicleType.CAR, owner, parkingHours);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public double getBaseRate() {
        return 50.0;
    }

    @Override
    public double calculateFee(int hours) {
        // Method overriding: cars receive a small premium after 5 hours.
        double fee = super.calculateFee(hours);
        return hours > 5 ? fee + 20 : fee;
    }
}
