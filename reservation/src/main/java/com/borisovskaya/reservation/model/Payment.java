package com.borisovskaya.reservation.model;

public class Payment {
    private String status;
    private Integer price;

    public Payment(String status, Integer price) {
        this.status = status;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "status='" + status + '\'' +
                ", price=" + price +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPrice() {
        return price;
    }
}
