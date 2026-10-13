package com.college.model;

public interface Payable {
    double calculateFee(int hours);

    default void printPaymentNote() {
        System.out.println("Payment must be completed before vehicle exit.");
    }
}
