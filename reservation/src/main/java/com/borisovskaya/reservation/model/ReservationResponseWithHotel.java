package com.borisovskaya.reservation.model;

public class ReservationResponseWithHotel {
    private String reservationUid;
    private HotelShortResponse hotel;
    private String startDate;
    private String endDate;
    private Integer discount;
    private String status;
    private Payment payment;

    @Override
    public String toString() {
        return "ReservationResponseWithHotel{" +
                "reservationUid='" + reservationUid + '\'' +
                ", hotel=" + hotel +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", payment=" + payment +
                '}';
    }

    public void setReservationUid(String reservationUid) {
        this.reservationUid = reservationUid;
    }

    public void setHotel(HotelShortResponse hotel) {
        this.hotel = hotel;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getReservationUid() {
        return reservationUid;
    }

    public HotelShortResponse getHotel() {
        return hotel;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getStatus() {
        return status;
    }

    public Payment getPayment() {
        return payment;
    }

    public ReservationResponseWithHotel(String reservationUid, HotelShortResponse hotel, String startDate, String endDate, Integer discount, String status, Payment payment) {
        this.reservationUid = reservationUid;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.status = status;
        this.payment = payment;
    }
}
