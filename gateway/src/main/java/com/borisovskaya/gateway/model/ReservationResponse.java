package com.borisovskaya.gateway.model;

public class ReservationResponse {
    private String reservationUid;
    private String hotelUid;
    private String startDate;
    private String endDate;
    private Integer discount;
    private String status;
    private Payment payment;

    public ReservationResponse(String reservationUid, String hotelUid, String startDate, String endDate, Integer discount, String status, Payment payment) {
        this.reservationUid = reservationUid;
        this.hotelUid = hotelUid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.status = status;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "ReservationResponse{" +
                "reservationUid='" + reservationUid + '\'' +
                ", hotelUid='" + hotelUid + '\'' +
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

    public void setHotelUid(String hotelUid) {
        this.hotelUid = hotelUid;
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

    public String getHotelUid() {
        return hotelUid;
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
}
