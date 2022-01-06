package com.borisovskaya.gateway.controller;

import com.borisovskaya.gateway.model.HotelsResponse;
import com.borisovskaya.gateway.model.LoyaltyResponse;
import com.borisovskaya.gateway.model.ReservationRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {
    private final RestTemplate restTemplate;

    public GatewayController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Value("${reservation.uri}")
    private String reservationUri;

    @Value("${loyalty.uri}")
    private String loyaltyUri;

    @GetMapping(value = "/gateway", produces = "application/json")
    public ResponseEntity temp() {
        return ResponseEntity.status(HttpStatus.OK).body("Hi from gateway!");
    }

    @GetMapping(value = "/loyalty", produces = "application/json")
    public String getLoyaltyByUsername(@RequestParam String username) {
        String loyaltyUri = "http://localhost:8081/api/v1/loyalty?username={un}";
        String resp = restTemplate.getForObject(loyaltyUri, String.class, username);
        return resp;
    }

    @PostMapping(value = "/reservations", consumes = "application/json", produces = "application/json")
    public ResponseEntity reservHotel(@RequestHeader("X-User-Name") String xUserName,
                                      @RequestHeader("Content-Type") String contentType,
                                      @RequestBody ReservationRequest reservationRequest) {

        // Check if hotel exists
        HotelsResponse hotel;
        Double temp_price = 1000.0;
        // Get discount
        String loyaltyUri = "http://localhost:8081/api/v1/loyalty?username={un}";
        LoyaltyResponse loyalty = restTemplate.getForObject(loyaltyUri, LoyaltyResponse.class, xUserName);
        Integer days = Period.between(LocalDate.parse(reservationRequest.getStartDate()),
                LocalDate.parse(reservationRequest.getEndDate())).getDays();
        Double price = days * temp_price * (1 - loyalty.getDiscount() * 0.01);

        String loyaltyIncrUri = "http://localhost:8081/api/v1/loyalty/incr?username={un}";
        LoyaltyResponse incrLoyalty = restTemplate.getForObject(loyaltyIncrUri, LoyaltyResponse.class, xUserName);

        return ResponseEntity.status(HttpStatus.OK).body(reservationRequest + "\nprice = " + price + "\ndiscount = " + loyalty.getDiscount() + incrLoyalty);
    }
}
