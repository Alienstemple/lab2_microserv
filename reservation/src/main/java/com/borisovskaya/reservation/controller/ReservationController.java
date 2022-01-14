package com.borisovskaya.reservation.controller;

import com.borisovskaya.reservation.model.*;
import com.borisovskaya.reservation.service.HotelsService;
import com.borisovskaya.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    public static final String STRING = "2021-10-11";
    public static final String START_DATE = "2021-10-08";
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HotelsService hotelsService;

    @Value ("${hellovar}")
    private String message;

    @PostMapping(value = "/reservations", consumes = "application/json", produces = "application/json")
    public ResponseEntity reservHotel(@RequestHeader("X-User-Name") String xUserName,
                                      @RequestBody ReservationRequest reservationRequest) {
        String loyaltyUri = "http://localhost:8081/api/v1/loyalty?username={un}";
        //LoyaltyResponse loyalty = restTemplate.getForObject(loyaltyUri, LoyaltyResponse.class, xUserName);
        Integer days = Period.between(LocalDate.parse(reservationRequest.getStartDate()),
                LocalDate.parse(reservationRequest.getEndDate())).getDays();
        //Double price = days * temp_price * (1 - loyalty.getDiscount() * 0.01);

//        String loyaltyIncrUri = "http://localhost:8081/api/v1/loyalty/incr?username={un}";
//        LoyaltyResponse incrLoyalty = restTemplate.getForObject(loyaltyIncrUri, LoyaltyResponse.class, xUserName);

        ReservationResponse reservationResponse = new ReservationResponse(
                "9b4ba1f7-e5ac-465b-ace4-7b54dec20f9a",
                "049161bb-badd-4fa8-9d90-87c9a82b0668",
                "2021-10-08",
                "2021-10-11",
                10,
                "PAID",
                new Payment("PAID", 27000));


        return ResponseEntity.status(HttpStatus.OK).body(reservationResponse);
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public HotelLongResp getHotelsList(@RequestParam Integer page, @RequestParam Integer size) {
        List<Hotels> resp =  hotelsService.getHotelsList(page, size);
        return new HotelLongResp(page, 1, 1, resp);
    }

    @GetMapping(value = "/reservations/{reservationUid}", produces = "application/json")
    public ResponseEntity getReservationInfo(@PathVariable String reservationUid, @RequestHeader("X-User-Name") String xUserName) {
        Hotels hotel = hotelsService.checkUid("049161bb-badd-4fa8-9d90-87c9a82b0668");
        HotelShortResponse hotelResp = new HotelShortResponse(hotel.getHotelUid(), hotel.getName(), hotel.getCountry()+", "+hotel.getCity()+", "+hotel.getAddress(), hotel.getStars());
        ReservationResponseWithHotel resp = new ReservationResponseWithHotel(
                reservationUid,
                hotelResp,
                "2021-10-08",
                "2021-10-11",
                10,
                "PAID",
                new Payment("PAID", 27000));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    public ListReservResp getUserReservations(@RequestHeader("X-User-Name") String xUserName) {
        Hotels hotel = hotelsService.checkUid("049161bb-badd-4fa8-9d90-87c9a82b0668");
        HotelShortResponse hotelResp = new HotelShortResponse(hotel.getHotelUid(), hotel.getName(), hotel.getCountry()+", "+hotel.getCity()+", "+hotel.getAddress(), hotel.getStars());
        List<ReservationResponseWithHotel> listRes = new LinkedList<ReservationResponseWithHotel>();
        listRes.add(new ReservationResponseWithHotel(
                "9b4ba1f7-e5ac-465b-ace4-7b54dec20f9a",
                hotelResp,
                "2021-10-08",
                "2021-10-11",
                10,
                "PAID",
                new Payment("PAID", 27000)));
        ListReservResp resp = new ListReservResp(listRes);
        return resp;
    }
}
