package com.borisovskaya.gateway.model;



import java.util.UUID;


public class Hotels {

    private Integer id;

    private UUID hotelUid;

    private String name;

    private String country;

    private String city;

    private String address;

    private Integer stars;

    private Integer price;

    public UUID getHotelUid() {
        return hotelUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", hotelUid='" + hotelUid + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", stars=" + stars +
                ", price=" + price +
                '}';
    }

    public Hotels(String name, String country, String city, String address, Integer stars, Integer price) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.stars = stars;
        this.price = price;
    }

    public Hotels() {
    }
}
