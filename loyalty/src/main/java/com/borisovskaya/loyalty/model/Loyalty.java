package com.borisovskaya.loyalty.model;

import javax.persistence.*;

@Entity
@Table(name = "loyalty")
public class Loyalty {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "reservation_count", nullable = false)
    private Integer reservationCount = 0;

    @Column(name = "status", nullable = false, length = 80)
    private String status = "BRONZE";

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Override
    public String toString() {
        return "{" +
                ", status='" + status + '\'' +
                ", discount=" + discount + '\'' +
                ", reservationCount=" + reservationCount +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getReservationCount() {
        return reservationCount;
    }

    public void setReservationCount(Integer reservationCount) {
        this.reservationCount = reservationCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Loyalty(String username, Integer reservationCount, String status, Integer discount) {
        this.username = username;
        this.reservationCount = reservationCount;
        this.status = status;
        this.discount = discount;
    }

    public Loyalty() {
    }
}
