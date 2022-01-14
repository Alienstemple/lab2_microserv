package com.borisovskaya.gateway.model;

import java.util.List;

public class AllUserInfo {
    private List<ReservationResponseWithHotel> reservations;
    private LoyaltyResponse loyalty;

    @Override
    public String toString() {
        return "AllUserInfo{" +
                "reservations=" + reservations +
                ", loyalty=" + loyalty +
                '}';
    }

    public AllUserInfo(List<ReservationResponseWithHotel> reservations, LoyaltyResponse loyalty) {
        this.reservations = reservations;
        this.loyalty = loyalty;
    }

    public void setReservations(List<ReservationResponseWithHotel> reservations) {
        this.reservations = reservations;
    }

    public void setLoyalty(LoyaltyResponse loyalty) {
        this.loyalty = loyalty;
    }

    public List<ReservationResponseWithHotel> getReservations() {
        return reservations;
    }

    public LoyaltyResponse getLoyalty() {
        return loyalty;
    }
}
