package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty.");

        double subtotal = 0;
        double shippingFee = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            int q = item.quantity;

            if (p instanceof Expirable) {
                Expirable e = (Expirable) p;
                if (e.getExpiryDate().isBefore(LocalDate.now())) {
                    throw new IllegalStateException(p.getName() + " is expired.");
                }
            }

            if (p.getQuantity() < q) {
                throw new IllegalStateException(p.getName() + " is out of stock.");
            }

            p.reduceQuantity(q);
            subtotal += p.getPrice() * q;

            if (p instanceof Shippable) {
                for (int i = 0; i < q; i++) {
                    shippables.add((Shippable) p);
                    shippingFee += 15;
                }
            }
        }

        double total = subtotal + shippingFee;
        if (!customer.pay(total)) {
            throw new IllegalStateException("Insufficient balance.");
        }

        ShippingService.ship(shippables);

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + " " + item.product.getPrice() * item.quantity);
        }
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFee);
        System.out.println("Amount " + total);
        System.out.println("Remaining balance: " + customer.getBalance());
    }
}
