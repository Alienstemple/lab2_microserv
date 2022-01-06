package com.borisovskaya.reservation.repository;

import com.borisovskaya.reservation.model.Hotels;
import com.borisovskaya.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelsRepository extends JpaRepository<Hotels, Integer> {
    Hotels findByHotelUid(UUID hotelUid);
}