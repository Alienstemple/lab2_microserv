package com.borisovskaya.reservation.model;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "reservation_uid", nullable = false)
    private String reservation_uid;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "payment_uid", nullable = false)
    private String payment_uid;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotel;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "start_date", nullable = false)
    private String start_date;      // TODO:TIMESTAMP WITH TIME ZONE,

    @Column(name = "end_date", nullable = false)
    private String end_data;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservation_uid='" + reservation_uid + '\'' +
                ", username='" + username + '\'' +
                ", payment_uid='" + payment_uid + '\'' +
                ", hotel=" + hotel +
                ", status='" + status + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }

    public Reservation(String reservation_uid, String username, String payment_uid, Hotels hotel, String status, String start_date, String end_date) {
        this.reservation_uid = reservation_uid;
        this.username = username;
        this.payment_uid = payment_uid;
        this.hotel = hotel;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Reservation() {
    }
}
