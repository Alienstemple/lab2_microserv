package com.borisovskaya.gateway.model;

public class HotelShortResponse {
    private String hotelUid;
    private String name;
    private String fullAddress;
    private Integer stars;

    public HotelShortResponse(String hotelUid, String name, String fullAddress, Integer stars) {
        this.hotelUid = hotelUid;
        this.name = name;
        this.fullAddress = fullAddress;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "HotelShortResponse{" +
                "hotelUid='" + hotelUid + '\'' +
                ", name='" + name + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", stars=" + stars +
                '}';
    }

    public void setHotelUid(String hotelUid) {
        this.hotelUid = hotelUid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getHotelUid() {
        return hotelUid;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Integer getStars() {
        return stars;
    }
}
