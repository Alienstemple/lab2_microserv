package com.borisovskaya.reservation.model;

public class ReservationRequest {
    private String hotelUid;
    private String startDate;
    private String endDate;

    public ReservationRequest() {
    }

    public ReservationRequest(String hotelUid, String startDate, String endDate) {
        this.hotelUid = hotelUid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getHotelUid() {
        return hotelUid;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
