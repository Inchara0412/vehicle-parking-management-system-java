package com.college.service;

import com.college.model.Vehicle;
import com.college.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String lotName;
    private int capacity;

    private final List<Vehicle> parkedVehicles = new ArrayList<>();
    private static int totalParkingTransactions = 0;

    public ParkingLot() {
        this("City Center Parking", 10);
    }

    public ParkingLot(String lotName, int capacity) {
        this.lotName = lotName;
        this.capacity = capacity;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

    public static int getTotalParkingTransactions() {
        return totalParkingTransactions;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking lot is full.");
            return false;
        }

        // Operator precedence: && is evaluated before ||; parentheses make the rule explicit.
        boolean valid = vehicle != null
                && vehicle.getRegistrationNumber() != null
                && !vehicle.getRegistrationNumber().trim().isEmpty();

        if (!valid) {
            System.out.println("Invalid vehicle details.");
            return false;
        }

        parkedVehicles.add(vehicle);
        totalParkingTransactions++;
        return true;
    }

    public Vehicle removeVehicle(String registrationNumber) {
        String key = registrationNumber.trim().toUpperCase();

        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getRegistrationNumber().trim().toUpperCase().equals(key)) {
                parkedVehicles.remove(vehicle);
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle findVehicle(String registrationNumber) {
        String key = registrationNumber.trim().toUpperCase();

        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getRegistrationNumber().trim().toUpperCase().equals(key)) {
                return vehicle;
            }
        }
        return null;
    }

    public int countByType(VehicleType type) {
        int count = 0; // local variable scope
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public void displayVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
            return;
        }

        System.out.println("\n--- Parked Vehicles ---");
        int position = 1;
        for (Vehicle vehicle : parkedVehicles) {
            System.out.printf("%d. %s%n", position++, vehicle);
        }
    }
}
