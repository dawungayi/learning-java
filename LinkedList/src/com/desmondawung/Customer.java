package com.desmondawung;

public class Customer {
    private String name;
    private double balance;

    // constructor
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
