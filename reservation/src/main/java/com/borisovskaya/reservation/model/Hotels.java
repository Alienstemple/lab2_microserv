package com.borisovskaya.reservation.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "hotel_uid", nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "guid")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID hotelUid;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "country", nullable = false, length = 80)
    private String country;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "price", nullable = false)
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
