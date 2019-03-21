package com.procourier.model;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Order {
    private Long id;
    private Seller seller;
    private Buyer buyer;
    private Courier courier;
    private Instant submittedTime;
    private Map<Product, Integer> orderLines;

    public Order(Long id, Seller seller, Buyer buyer,
                 Courier courier, Instant submittedTime, Map<Product, Integer> orderLines) {
        this.id = id;
        this.seller = Objects.requireNonNull(seller);
        this.buyer = Objects.requireNonNull(buyer);
        this.courier = Objects.requireNonNull(courier);
        this.submittedTime = Objects.requireNonNull(submittedTime);
        this.orderLines = Collections.unmodifiableMap(orderLines);
    }

    public Order(Long id, Seller seller, Buyer buyer, Courier courier, Map<Product, Integer> orderLines) {
        this(id, seller, buyer, courier, Instant.now(), orderLines);
    }

    public Seller getSeller() {
        return seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Courier getCourier() {
        return courier;
    }

    public Instant getSubmittedTime() {
        return submittedTime;
    }

    public Map<Product, Integer> getOrderLines() {
        return orderLines;
    }

    public Long getId() {
        return id;
    }
}
