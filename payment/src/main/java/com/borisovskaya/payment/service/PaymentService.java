package com.borisovskaya.payment.service;

import com.borisovskaya.payment.model.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface PaymentService {
    Payment newPayment(Integer price);
    Payment cancelPayment(UUID paymentUid);
}
