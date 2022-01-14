package com.borisovskaya.gateway.controller;

import com.borisovskaya.gateway.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {
    private final RestTemplate restTemplate;

    public GatewayController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private String reservationUri = "https://reservation-service-lab2.herokuapp.com/api/v1";
    //private String reservationUri = "http://localhost:8083/api/v1";

    private String loyaltyUri = "https://loyalty-service-lab2.herokuapp.com/api/v1";
    //private String loyaltyUri = "http://localhost:8081/api/v1";

    private String paymentUri = "https://payment-service-lab2.herokuapp.com/api/v1";
    //private String paymentUri = "http://localhost:8082/api/v1";

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity temp() {
        return ResponseEntity.status(HttpStatus.OK).body("Hi from gateway!");
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public ResponseEntity<Object> getHotelsList(@RequestParam Integer page, @RequestParam Integer size) {
        String reservUri = reservationUri + "/hotels?page={page}&size={size}";
        HotelLongResp hotels = restTemplate.getForObject(reservUri, HotelLongResp.class, page, size);

        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @PostMapping(value = "/reservations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ReservationResponse> postNewReservation(@RequestHeader("X-User-Name") String xUserName,
                                                     @RequestBody ReservationRequest reservationRequest) {

        String resUri = reservationUri + "/reservations";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-User-Name", xUserName);
        HttpEntity request = new HttpEntity(reservationRequest, headers);

        ResponseEntity<ReservationResponse> resp = restTemplate.exchange(resUri, HttpMethod.POST, request, ReservationResponse.class);

        String loyaltyIncrUri = loyaltyUri + "/loyalty/incr?username={un}";
        LoyaltyResponse incrLoyalty = restTemplate.getForObject(loyaltyIncrUri, LoyaltyResponse.class, xUserName);
        //return ResponseEntity.status(HttpStatus.OK).body("{\n    \"reservationUid\": \"9b4ba1f7-e5ac-465b-ace4-7b54dec20f9a\",\n    \"hotelUid\": \"049161bb-badd-4fa8-9d90-87c9a82b0668\",\n    \"startDate\": \"2021-10-08\",\n    \"endDate\": \"2021-10-11\",\n    \"discount\": 10,\n    \"status\": \"PAID\",\n    \"payment\": {\n        \"status\": \"PAID\",\n        \"price\": 27000\n    }\n}");
        return resp;
    }

    @GetMapping(value = "/reservations/{reservationUid}", produces = "application/json")
    public ResponseEntity<ReservationResponseWithHotel> getReservationInfo(@PathVariable String reservationUid,
                                                      @RequestHeader("X-User-Name") String xUserName) {
        String resUri = reservationUri + "/reservations/{reservationUid}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-User-Name", xUserName);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ReservationResponseWithHotel> resp = restTemplate.exchange(resUri, HttpMethod.GET, request, ReservationResponseWithHotel.class, reservationUid);
        return resp;
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    public ResponseEntity getUserReservations(@RequestHeader("X-User-Name") String xUserName) {
        String resUri = reservationUri + "/reservations";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-User-Name", xUserName);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ListReservResp> resp = restTemplate.exchange(resUri,  HttpMethod.GET, request, ListReservResp.class);
        //ResponseEntity resp = restTemplate.exchange(resUri, HttpMethod.GET, request, ResponseEntity.class);
        ResponseEntity finalResponse = ResponseEntity.status(HttpStatus.OK).body(resp.getBody().getList());
        return finalResponse;

        //return ResponseEntity.status(HttpStatus.OK).body("[\n    {\n        \"reservationUid\": \"9b4ba1f7-e5ac-465b-ace4-7b54dec20f9a\",\n        \"hotel\": {\n            \"hotelUid\": \"049161bb-badd-4fa8-9d90-87c9a82b0668\",\n            \"name\": \"Ararat Park Hyatt Moscow\",\n            \"fullAddress\": \"Россия, Москва, Неглинная ул., 4\",\n            \"stars\": 5\n        },\n        \"startDate\": \"2021-10-08\",\n        \"endDate\": \"2021-10-11\",\n        \"status\": \"PAID\",\n        \"payment\": {\n            \"status\": \"PAID\",\n            \"price\": 27000\n        }\n    }\n]");
    }

    @GetMapping(value = "/me", produces = "application/json")
    public ResponseEntity<Object> getUserInfo(@RequestHeader("X-User-Name") String xUserName) {
        String resUri = reservationUri + "/reservations";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-User-Name", xUserName);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ListReservResp> resp = restTemplate.exchange(resUri,  HttpMethod.GET, request, ListReservResp.class);

        String loyalUri = loyaltyUri + "/loyalty";

        HttpHeaders lHeaders = new HttpHeaders();
        lHeaders.setContentType(MediaType.APPLICATION_JSON);
        lHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        lHeaders.set("X-User-Name", xUserName);
        HttpEntity lRequest = new HttpEntity(lHeaders);

        ResponseEntity<LoyaltyResponse> lResp = restTemplate.exchange(loyalUri, HttpMethod.GET, lRequest, LoyaltyResponse.class);


        return ResponseEntity.status(HttpStatus.OK).body(new AllUserInfo(resp.getBody().getList(), lResp.getBody()));
        //return ResponseEntity.status(HttpStatus.OK).body("{\n    \"reservations\": [\n        {\n            \"reservationUid\": \"9b4ba1f7-e5ac-465b-ace4-7b54dec20f9a\",\n            \"hotel\": {\n                \"hotelUid\": \"049161bb-badd-4fa8-9d90-87c9a82b0668\",\n                \"name\": \"Ararat Park Hyatt Moscow\",\n                \"fullAddress\": \"Россия, Москва, Неглинная ул., 4\",\n                \"stars\": 5\n            },\n            \"startDate\": \"2021-10-08\",\n            \"endDate\": \"2021-10-11\",\n            \"status\": \"PAID\",\n            \"payment\": {\n                \"status\": \"PAID\",\n                \"price\": 27000\n            }\n        }\n    ],\n    \"loyalty\": {\n        \"status\": \"GOLD\",\n        \"discount\": 10\n    }\n}");
    }

    @GetMapping(value = "/loyalty", produces = "application/json")
    public ResponseEntity<LoyaltyResponse> getLoyaltyByUsername(@RequestHeader("X-User-Name") String xUserName) {
        String loyalUri = loyaltyUri + "/loyalty";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-User-Name", xUserName);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<LoyaltyResponse> resp = restTemplate.exchange(loyalUri, HttpMethod.GET, request, LoyaltyResponse.class);
        return resp;
    }

    @DeleteMapping(value = "/reservations/{reservationUid}", produces = "text/plain")
    public ResponseEntity<Object> deleteReservation(@PathVariable String reservationUid) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
