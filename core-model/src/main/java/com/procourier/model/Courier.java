package com.procourier.model;

import java.util.Objects;

public final class Courier {
    private Long id;
    private String companyName;
    private Address headquarters;
    private Long pricePerDistance;
    private Long getPricePerWeight;

    public Courier(Long id, String companyName, Address headquarters, Long pricePerDistance, Long getPricePerWeight) {
        this.id = id;
        this.companyName = Objects.requireNonNull(companyName);
        this.headquarters = Objects.requireNonNull(headquarters);
        this.pricePerDistance = Objects.requireNonNull(pricePerDistance);
        this.getPricePerWeight = Objects.requireNonNull(getPricePerWeight);
    }
}
