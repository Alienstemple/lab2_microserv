package com.borisovskaya.payment.service;

import com.borisovskaya.payment.model.Payment;
import com.borisovskaya.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment newPayment(Integer price) {
        return paymentRepository.save(new Payment("PAID", price));
    }

    @Override
    public Payment cancelPayment(String paymentUid) {
        Payment payment = paymentRepository.findByPaymentUid(paymentUid);
        payment.setStatus("CANCELED");
        return paymentRepository.save(payment);
    }
}
