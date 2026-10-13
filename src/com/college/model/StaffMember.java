package com.college.model;

public class StaffMember extends Person {
    private String staffId;
    private double hourlyRate;

    public StaffMember() {
        this("S000", "Unknown", "Not provided", 0.0);
    }

    public StaffMember(String staffId, String name, String phone, double hourlyRate) {
        super(name, phone); // super constructor call
        this.staffId = staffId;
        this.hourlyRate = hourlyRate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getRole() {
        return "Parking Staff";
    }

    @Override
    public String toString() {
        return String.format("StaffMember{id='%s', name='%s', rate=%.2f}",
                staffId, getName(), hourlyRate);
    }
}
