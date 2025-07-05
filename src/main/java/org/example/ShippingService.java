package org.example;

import java.util.List;

class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            System.out.println(item.getName() + " " + item.getWeight() + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
