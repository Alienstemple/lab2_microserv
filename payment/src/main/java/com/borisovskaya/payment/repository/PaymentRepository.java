package com.borisovskaya.payment.repository;

import com.borisovskaya.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByPaymentUid(UUID paymentUid);
}
