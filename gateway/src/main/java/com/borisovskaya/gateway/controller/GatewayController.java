package com.borisovskaya.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {

    //@Autowired
    //private ReservationService reservationService;
    @Value("${reservation.uri}")
    private String reservationUri;

    @GetMapping(value = "/gateway", produces = "application/json")
    public ResponseEntity temp() {
        return ResponseEntity.status(HttpStatus.OK).body("Hi from gateway!");
    }

    @GetMapping(value = "/gateway/reservation", produces = "application/json")
    public ResponseEntity temp_reserv() {
        WebClient webClient = WebClient.create("${reservation.uri}");
        WebClient.ResponseSpec resp = webClient.get()
                .uri("api/v1/reservation")
                .retrieve();

        return ResponseEntity.status(HttpStatus.OK).body("Hi from gateway!");
    }
}
