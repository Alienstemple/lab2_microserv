package com.borisovskaya.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    //@Autowired
    //private LoyaltyService loyaltyService;

    @GetMapping(value = "/payment", produces = "application/json")
    public ResponseEntity temp() {
        return ResponseEntity.status(HttpStatus.OK).body("Hi from payment service");
    }
}