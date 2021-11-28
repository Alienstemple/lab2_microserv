package com.borisovskaya.loyalty.model;

public class LoyaltyResponse {
    private String status;
    private Integer discount;
    private Integer reservationCount;

    public LoyaltyResponse(String status, Integer discount, Integer reservationCount) {
        this.status = status;
        this.discount = discount;
        this.reservationCount = reservationCount;
    }

    public String getStatus() {
        return status;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Integer getReservationCount() {
        return reservationCount;
    }
}
