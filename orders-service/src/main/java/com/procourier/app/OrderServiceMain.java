package com.procourier.app;

import com.procourier.model.*;
import com.procourier.repository.CollectionRepository;
import spark.Spark;

import java.util.Map;

public class OrderServiceMain {
    public static void main(String[] args) {
        final var repository = new CollectionRepository();
        final var handler = new OrdersHandler(repository);

        final Address address = new Address("DJ", "Craiova", "Nicolae Titulescu");
        final Seller seller = new Seller("Evomag", address);

        final Address cosminAddress = new Address("DJ", "Craiova", "Ileana Cosanzeana");
        final Buyer buyer = new Buyer("Cosmin", address);

        final Address courierAddress = new Address("OT", "Slatina", "Cantemir");
        final Courier courier = new Courier(1L, "ExpressFun", courierAddress,
                5L, 7L);

        final var products = Map.of(new Product(20L, "Jeans", "Men Jeans", 22L), 4);

        final Order order = new Order(6L, seller, buyer, courier, products);
        repository.put(order);

        Spark.port(8082);
        Spark.threadPool(26, 10, 2000);
        Spark.get("/orders/:id", handler);
    }
}
