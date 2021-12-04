package com.borisovskaya.payment.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "payment_uid")
    private String paymentUid = UUID.randomUUID().toString();

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "price", nullable = false)
    private Integer price;

    public String getPayment_uid() {
        return paymentUid;
    }

    public void setPayment_uid(String payment_uid) {
        this.paymentUid = payment_uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payment_uid='" + paymentUid + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }

    public Payment(String status, Integer price) {
        this.status = status;
        this.price = price;
    }
}
