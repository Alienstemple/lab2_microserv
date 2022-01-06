package com.borisovskaya.reservation.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "reservation_uid", nullable = false)
    private UUID reservationUid;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "payment_uid", nullable = false)
    private String paymentUid;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotel;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "start_date", nullable = false)
    private String startDate;      // TODO:TIMESTAMP WITH TIME ZONE,

    @Column(name = "end_data", nullable = false)
    private String endDate;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservation_uid='" + reservationUid + '\'' +
                ", username='" + username + '\'' +
                ", paymentUid='" + paymentUid + '\'' +
                ", hotel=" + hotel +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public Reservation(UUID reservationUid, String username, String paymentUid, Hotels hotel, String status, String startDate, String endDate) {
        this.reservationUid = reservationUid;
        this.username = username;
        this.paymentUid = paymentUid;
        this.hotel = hotel;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reservation() {
    }
}
