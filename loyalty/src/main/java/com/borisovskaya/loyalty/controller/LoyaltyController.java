package com.borisovskaya.loyalty.controller;

import com.borisovskaya.loyalty.model.Loyalty;
import com.borisovskaya.loyalty.model.LoyaltyResponse;
import com.borisovskaya.loyalty.service.LoyaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoyaltyController {

    @Autowired
    private LoyaltyService loyaltyService;

    @GetMapping(value = "/loyalty/ping", produces = "application/json")
    public String pingLoyalty() {
        return "Hi from loyalty!";
    }

    @GetMapping(value = "/loyalty", produces = "application/json")
    public LoyaltyResponse getLoyaltyByUsername(@RequestHeader("X-User-Name") String xUserName) {
        //Loyalty resp = loyaltyService.getLoyalty(username);
        return loyaltyService.getLoyalty(xUserName);
    }

    @GetMapping(value = "/loyalty/incr", produces = "application/json")
    public ResponseEntity<LoyaltyResponse> incrementReservCount(@RequestParam String username) {
        return new ResponseEntity<LoyaltyResponse>(loyaltyService.incrementReservCount(username), HttpStatus.OK);
    }

    @GetMapping(value = "/loyalty/decr", produces = "application/json")
    public ResponseEntity<LoyaltyResponse> decrementReservCount(@RequestParam String username) {
        return new ResponseEntity<LoyaltyResponse>(loyaltyService.decrementReservCount(username), HttpStatus.OK);
    }
}