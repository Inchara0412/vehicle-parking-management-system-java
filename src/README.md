# Vehicle Parking Management System - Java OOP Project

## 1. Project Overview
This console-based Vehicle Parking Management System demonstrates Unit-I and Unit-II Java Object-Oriented Programming concepts in a practical real-world application. It supports parking, searching, displaying, fee calculation, vehicle exit, and summary operations.

## 2. Packages
- `com.college.model` - model classes, inheritance hierarchy, enum and interface
- `com.college.service` - parking business logic
- `com.college.app` - console application and user interaction

## 3. How to Compile and Run

From the project root:

```text
javac -d out src/com/college/model/*.java src/com/college/service/*.java src/com/college/app/*.java
java -cp out com.college.app.ParkingManagementApp
```

Or open the project folder in VS Code and run `ParkingManagementApp.java`.

## 4. Traceability of Mandatory Features

| No. | Mandatory feature | Implementation |
|---|---|---|
| 1 | 3-4+ encapsulated classes | `Person`, `Customer`, `StaffMember`, `Vehicle`, `Car`, `Bike`, `Truck`, `ParkingLot` use private fields + getters/setters |
| 2 | Data types, constants, variable scope | `Vehicle.GST_RATE`, instance fields in models, static counters, local variables in `ParkingManagementApp`/`ParkingLot` |
| 3 | Operators + precedence | `ParkingManagementApp.showSummary()` uses `cars + bikes * 1 + trucks * 2`; `ParkingLot.parkVehicle()` uses `&&` |
| 4 | Type conversion/casting | `ParkingManagementApp.parkNewVehicle()` casts `double exactFee` to `int roundedFee` |
| 5 | Enum | `VehicleType.java` |
| 6 | Control + jump statements | `switch`, `if/else`, `while`, `for`, `break`, `continue`, `return` in app/service classes |
| 7 | Arrays of objects | `Vehicle[] demoVehicles` in `ParkingManagementApp` |
| 8 | Console I/O + formatted output | `Scanner`, `System.out.printf`, `String.format` |
| 9 | Constructor overloading | Default + parameterized constructors in `Person`, `Customer`, `StaffMember`, `Vehicle`, `Car`, `Bike`, `Truck`, `ParkingLot` |
| 10 | Method overloading | `ParkingManager.calculateFee(Vehicle)` and `calculateFee(Vehicle, int)` |
| 11 | Static fields/methods | `Vehicle.totalVehicles`, `ParkingLot.totalParkingTransactions`, `ParkingManagementApp.menuRuns` |
| 12 | `this` reference | Constructors throughout model/service classes use `this.field = parameter`; constructor chaining uses `this(...)` |
| 13 | String methods | `trim()`, `contains()`, `equalsIgnoreCase()`, `toUpperCase()`, `isEmpty()` |
| 14 | Base class + 2 subclasses | `Person -> Customer, StaffMember`; also `Vehicle -> Car, Bike, Truck` |
| 15 | `super` keyword | `Customer` and `StaffMember` call `super(...)`; `Customer.displayPerson()` calls `super.displayPerson()` |
| 16 | Overriding + dynamic binding | `Person personRef = new Customer(...)`; overridden `displayPerson()` is selected at runtime |
| 17 | Abstract class + method | `Person` and `Vehicle` are abstract; `getRole()` / `getBaseRate()` are abstract |
| 18 | Interface + interface reference | `Payable`; `Payable payable = vehicle;` |
| 19 | Object method override | `Customer.equals()` and `toString()`; `Vehicle.toString()` |
| 20 | Final method/class | `Vehicle.printReceipt()` is final so subclasses cannot change the common receipt format |
| 21 | 2+ custom packages | `com.college.model`, `com.college.service`, `com.college.app` with imports |

## 5. Sample Console Run

```text
==============================================
      VEHICLE PARKING MANAGEMENT SYSTEM
==============================================
Name: Ananya | Phone: 9876543210 | Role: Customer
Customer ID: C101
Name: Ravi | Phone: 9123456780 | Role: Parking Staff

1. Park Vehicle
2. Display Parked Vehicles
3. Search Vehicle
4. Vehicle Exit
5. Summary
0. Exit
Enter your choice: 1

Enter customer name: Rahul
Enter phone: 9876501234
Enter registration number: KA01AB1234
Enter vehicle type (CAR/BIKE/TRUCK): CAR
Enter parking hours: 4

Vehicle parked successfully!
Vehicle{reg='KA01AB1234', type=CAR, owner=Rahul}
Payment must be completed before vehicle exit.
Exact fee: Rs. 236.00 | Rounded fee (int cast): Rs. 236
Receipt -> KA01AB1234 | CAR | 4 hour(s) | Fee: Rs. 236.00

Enter your choice: 2

--- Parked Vehicles ---
1. Vehicle{reg='KA01AB1234', type=CAR, owner=Rahul}

Enter your choice: 5

--- Parking Summary ---
Lot: City Center Parking
Capacity: 20
Currently parked: 1
Cars: 1
Bikes: 0
Trucks: 0
Weighted occupied slots: 1
Total vehicles created: 1
Parking transactions: 1
Menu runs: 3

Enter your choice: 0
Thank you for using the system.
```

## 6. Viva Preparation
1. Why is `Vehicle` abstract? - Because it defines common vehicle behavior while forcing each vehicle type to provide its own base rate.
2. How is dynamic binding demonstrated? - A `Person` reference stores a `Customer` object, and the overridden method is selected at runtime.
3. Why is `Payable payable = vehicle` used? - It demonstrates programming to an interface and interface reference access.
