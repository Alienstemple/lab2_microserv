package com.borisovskaya.payment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "payment_uid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String paymentUid;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "price", nullable = false)
    private Integer price;

    public String getPaymentUid() {
        return paymentUid;
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
