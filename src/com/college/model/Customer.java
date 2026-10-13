package com.college.model;

public class Customer extends Person {
    private String customerId;

    public Customer() {
        this("C000", "Unknown", "Not provided");
    }

    public Customer(String customerId, String name, String phone) {
        super(name, phone);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public void displayPerson() {
        super.displayPerson(); // super method call
        System.out.println("Customer ID: " + customerId);
    }

    @Override
    public String toString() {
        return String.format("Customer{id='%s', name='%s', phone='%s'}",
                customerId, getName(), getPhone());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return customerId.equalsIgnoreCase(other.customerId);
    }
}
