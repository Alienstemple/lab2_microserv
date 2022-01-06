package com.borisovskaya.reservation.model;

import java.util.UUID;

public class HotelUidRequest {
    private UUID hotelUid;

    public HotelUidRequest() {
    }

    public HotelUidRequest(String hotelUid) {
        this.hotelUid = UUID.fromString(hotelUid);
    }

    public UUID getHotelUid() {
        return hotelUid;
    }
}
