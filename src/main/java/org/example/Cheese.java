package org.example;

import java.time.LocalDate;

class Cheese extends Product implements Shippable, Expirable {
    private double weight;
    private LocalDate expiryDate;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public double getWeight() { return weight; }
    public LocalDate getExpiryDate() { return expiryDate; }
}

