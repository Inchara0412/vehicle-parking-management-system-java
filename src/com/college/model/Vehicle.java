package com.college.model;

import java.util.Locale;

public abstract class Vehicle implements Payable {
    private String registrationNumber;
    private VehicleType type;
    private Customer owner;
    private int parkingHours;

    private static int totalVehicles = 0;
    public static final double GST_RATE = 0.18;

    public Vehicle() {
        this("UNKNOWN", VehicleType.BIKE, new Customer(), 0);
    }

    public Vehicle(String registrationNumber, VehicleType type,
                   Customer owner, int parkingHours) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.owner = owner;
        this.parkingHours = parkingHours;
        totalVehicles++;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public int getParkingHours() {
        return parkingHours;
    }

    public void setParkingHours(int parkingHours) {
        this.parkingHours = parkingHours;
    }

    public static int getTotalVehicles() {
        return totalVehicles;
    }

    public abstract double getBaseRate();

    @Override
    public double calculateFee(int hours) {
        if (hours <= 0) return 0.0;
        double subtotal = getBaseRate() * hours;
        double tax = subtotal * GST_RATE;
        return subtotal + tax;
    }

    // Final because the common parking receipt format should not be changed by subclasses.
    public final void printReceipt() {
        double fee = calculateFee(parkingHours);
        System.out.printf(Locale.US,
                "Receipt -> %s | %s | %d hour(s) | Fee: Rs. %.2f%n",
                registrationNumber, type, parkingHours, fee);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "Vehicle{reg='%s', type=%s, owner=%s, hours=%d}",
                registrationNumber, type, owner.getName(), parkingHours);
    }
}
