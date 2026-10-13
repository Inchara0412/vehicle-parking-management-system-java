package com.college.app;

import com.college.model.Customer;
import com.college.model.Payable;
import com.college.model.Person;
import com.college.model.StaffMember;
import com.college.model.Vehicle;
import com.college.model.VehicleType;
import com.college.service.ParkingLot;
import com.college.service.ParkingManager;

import java.util.Locale;
import java.util.Scanner;

public class ParkingManagementApp {
    private static final ParkingLot LOT = new ParkingLot("City Center Parking", 20);
    private static int menuRuns = 0; // static field shared by all executions of the class

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingManager manager = new ParkingManager(LOT);

        // Arrays of objects: one parent-reference array holds different child objects.
        Vehicle[] demoVehicles = new Vehicle[3];

        System.out.println("==============================================");
        System.out.println("      VEHICLE PARKING MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        // Parent reference holding a child object -> dynamic binding.
        Person personRef = new Customer("C101", "Ananya", "9876543210");
        personRef.displayPerson();

        StaffMember staff = new StaffMember("S01", "Ravi", "9123456780", 120.50);
        staff.displayPerson();

        boolean running = true;
        while (running) {
            menuRuns++;
            printMenu();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    parkNewVehicle(scanner, manager, demoVehicles);
                    break;
                case 2:
                    LOT.displayVehicles();
                    break;
                case 3:
                    searchVehicle(scanner, manager);
                    break;
                case 4:
                    exitVehicle(scanner, manager);
                    break;
                case 5:
                    showSummary();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Park Vehicle");
        System.out.println("2. Display Parked Vehicles");
        System.out.println("3. Search Vehicle");
        System.out.println("4. Vehicle Exit");
        System.out.println("5. Summary");
        System.out.println("0. Exit");
    }

    private static void parkNewVehicle(Scanner scanner, ParkingManager manager,
                                       Vehicle[] demoVehicles) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();

        // String methods: trim(), contains(), equalsIgnoreCase().
        if (name.isEmpty() || name.contains("  ")) {
            System.out.println("Please enter a valid name.");
            return;
        }

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter registration number: ");
        String registration = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter vehicle type (CAR/BIKE/TRUCK): ");
        String typeText = scanner.nextLine().trim();

        VehicleType type;
        try {
            type = VehicleType.valueOf(typeText.toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid vehicle type.");
            return;
        }

        System.out.print("Enter parking hours: ");
        int hours;
        try {
            hours = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException ex) {
            System.out.println("Hours must be a whole number.");
            return;
        }

        if (hours <= 0) {
            System.out.println("Hours must be greater than zero.");
            return;
        }

        Customer customer = new Customer("C" + (LOT.getParkedVehicles().size() + 101),
                name, phone);

        Vehicle vehicle = manager.createVehicle(registration, type, customer, hours);

        if (vehicle == null) {
            System.out.println("Vehicle could not be created.");
            return;
        }

        if (manager.register(vehicle)) {
            // Store in an array of objects.
            for (int i = 0; i < demoVehicles.length; i++) {
                if (demoVehicles[i] == null) {
                    demoVehicles[i] = vehicle;
                    break;
                }
            }

            System.out.println("\nVehicle parked successfully!");
            System.out.println(vehicle);

            // Interface reference demonstrating interface implementation.
            Payable payable = vehicle;
            payable.printPaymentNote();

            double exactFee = manager.calculateFee(vehicle);
            int roundedFee = (int) exactFee; // explicit double-to-int casting
            System.out.printf(Locale.US,
                    "Exact fee: Rs. %.2f | Rounded fee (int cast): Rs. %d%n",
                    exactFee, roundedFee);

            vehicle.printReceipt();
        }
    }

    private static void searchVehicle(Scanner scanner, ParkingManager manager) {
        System.out.print("Enter registration number to search: ");
        String registration = scanner.nextLine();

        Vehicle found = manager.search(registration);

        if (found == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("Vehicle found:");
        System.out.println(found);
    }

    private static void exitVehicle(Scanner scanner, ParkingManager manager) {
        System.out.print("Enter registration number for exit: ");
        String registration = scanner.nextLine().trim();

        Vehicle vehicle = manager.exit(registration);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("Vehicle exited successfully.");
        System.out.printf(Locale.US, "Final fee: Rs. %.2f%n",
                manager.calculateFee(vehicle));
    }

    private static void showSummary() {
        int cars = LOT.countByType(VehicleType.CAR);
        int bikes = LOT.countByType(VehicleType.BIKE);
        int trucks = LOT.countByType(VehicleType.TRUCK);

        // Operator precedence: multiplication happens before addition.
        int estimatedSlots = cars + bikes * 1 + trucks * 2;

        System.out.println("\n--- Parking Summary ---");
        System.out.println("Lot: " + LOT.getLotName());
        System.out.println("Capacity: " + LOT.getCapacity());
        System.out.println("Currently parked: " + LOT.getParkedVehicles().size());
        System.out.println("Cars: " + cars);
        System.out.println("Bikes: " + bikes);
        System.out.println("Trucks: " + trucks);
        System.out.println("Weighted occupied slots: " + estimatedSlots);
        System.out.println("Total vehicles created: " + Vehicle.getTotalVehicles());
        System.out.println("Parking transactions: " + ParkingLot.getTotalParkingTransactions());
        System.out.println("Menu runs: " + menuRuns);
    }
}
