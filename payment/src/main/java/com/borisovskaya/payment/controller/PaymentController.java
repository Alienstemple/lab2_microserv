package com.borisovskaya.payment.controller;

import com.borisovskaya.payment.model.Payment;
import com.borisovskaya.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/new", produces = "application/json")
    public ResponseEntity<Payment> newPayment(@RequestParam Integer price) {
        return new ResponseEntity<Payment>(paymentService.newPayment(price), HttpStatus.OK);
    }

    @GetMapping(value = "/payment/cancel", produces = "application/json")
    public ResponseEntity cancelPayment(@RequestParam String paymentUid) {
        return new ResponseEntity<Payment>(paymentService.cancelPayment(UUID.fromString(paymentUid)), HttpStatus.OK);
    }

}