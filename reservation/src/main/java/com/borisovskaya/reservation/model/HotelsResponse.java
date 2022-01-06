package com.borisovskaya.reservation.model;

import java.util.UUID;

public class HotelsResponse {
    private Integer id;
    private UUID hotelUid;
    private String name;
    private String country;
    private String city;
    private String address;
    private Integer stars;
    private Integer price;

    public HotelsResponse(Integer id, UUID hotelUid, String name, String country, String city, String address, Integer stars, Integer price) {
        this.id = id;
        this.hotelUid = hotelUid;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.stars = stars;
        this.price = price;
    }

    public HotelsResponse() {
    }

    public Integer getPrice() {
        return price;
    }
}
