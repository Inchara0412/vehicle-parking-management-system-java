package com.college.service;

import com.college.model.Bike;
import com.college.model.Car;
import com.college.model.Customer;
import com.college.model.Truck;
import com.college.model.Vehicle;
import com.college.model.VehicleType;

public class ParkingManager {
    private final ParkingLot lot;

    public ParkingManager(ParkingLot lot) {
        this.lot = lot;
    }

    public Vehicle createVehicle(String registration, VehicleType type,
                                 Customer owner, int hours) {
        switch (type) {
            case CAR:
                return new Car(registration, owner, hours, 5);
            case BIKE:
                return new Bike(registration, owner, hours, true);
            case TRUCK:
                return new Truck(registration, owner, hours, 2.5);
            default:
                return null;
        }
    }

    public double calculateFee(Vehicle vehicle, int hours) {
        return vehicle.calculateFee(hours);
    }

    // Method overloading: calculate fee using the vehicle's stored hours.
    public double calculateFee(Vehicle vehicle) {
        return vehicle.calculateFee(vehicle.getParkingHours());
    }

    public boolean register(Vehicle vehicle) {
        return lot.parkVehicle(vehicle);
    }

    public Vehicle search(String registration) {
        return lot.findVehicle(registration);
    }

    public Vehicle exit(String registration) {
        return lot.removeVehicle(registration);
    }
}
