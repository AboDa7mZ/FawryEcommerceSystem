package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Abdulrahman", 2000);

        Product cheese = new Cheese("Cheese", 100, 10, 0.2, LocalDate.of(2025, 12, 31));
        Product biscuits = new Cheese("Biscuits", 150, 5, 0.7, LocalDate.of(2025, 12, 31));
        Product scratchCard = new ScratchCard("Scratch Card", 50, 20);
        Product tv = new TV("TV",500,15,2.0);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}