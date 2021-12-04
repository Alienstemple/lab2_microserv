package com.borisovskaya.payment.service;

import com.borisovskaya.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentService {
    Payment newPayment(Integer price);
    Payment cancelPayment(String paymentUid);
}
