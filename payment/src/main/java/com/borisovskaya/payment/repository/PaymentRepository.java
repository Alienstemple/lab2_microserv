package com.borisovskaya.payment.repository;

import com.borisovskaya.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByPaymentUid(String paymentUid);
}
