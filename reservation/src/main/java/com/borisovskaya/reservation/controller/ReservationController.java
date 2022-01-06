package com.borisovskaya.reservation.controller;

import com.borisovskaya.reservation.model.HotelUidRequest;
import com.borisovskaya.reservation.model.Hotels;
import com.borisovskaya.reservation.model.HotelsResponse;
import com.borisovskaya.reservation.model.ReservationRequest;
import com.borisovskaya.reservation.service.HotelsService;
import com.borisovskaya.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HotelsService hotelsService;

    @Value ("${hellovar}")
    private String message;

    @PostMapping(value = "/reservations", consumes = "application/json", produces = "application/json")
    public ResponseEntity reservHotel(@RequestHeader("X-User-Name") String xUserName,
                                      @RequestHeader("Content-Type") String contentType,
                                      @RequestBody ReservationRequest reservationRequest) {


        return ResponseEntity.status(HttpStatus.OK).body(reservationRequest);
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public ResponseEntity<Object> getHotelsList(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelsService.getHotelsList(page, size));
    }

//    @GetMapping(value = "/hotel_exist/{hotelUid}", produces = "application/json")
//    public ResponseEntity<Object> getHotelExist(@PathVariable("hotelUid") UUID hotelUid) {// TODO: intern serv err 500 Parameter value [049161bb-badd-4fa8-9d90-87c9a82b0668] did not match expected type [java.lang.String (n/a)]
//        return ResponseEntity.status(HttpStatus.OK).body(hotelsService.checkUid(hotelUid));
////        if (hotelsService.checkUid(UUID.fromString(hotelUid)))
////            return ResponseEntity.status(HttpStatus.OK).body("This hotel exists!");
////        else
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such hotel!");
//    }

    @GetMapping(value = "/hotel_exist", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getHotelExist(@RequestBody HotelUidRequest hotelUid) {// TODO: intern serv err 500 Parameter value [049161bb-badd-4fa8-9d90-87c9a82b0668] did not match expected type [java.lang.String (n/a)]
        return ResponseEntity.status(HttpStatus.OK).body(hotelsService.checkUid(hotelUid.getHotelUid()));
    }
}
