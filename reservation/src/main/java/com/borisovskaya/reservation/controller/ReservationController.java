package com.borisovskaya.reservation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    //@Autowired
    //private ReservationService reservationService;
    @Value ("${hellovar}")
    private String message;

    @GetMapping(value = "/reservation", produces = "application/json")
    public ResponseEntity temp() {
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
