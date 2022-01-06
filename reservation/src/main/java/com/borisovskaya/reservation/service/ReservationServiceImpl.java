package com.borisovskaya.reservation.service;

import com.borisovskaya.reservation.model.Reservation;
import com.borisovskaya.reservation.model.ReservationResponse;
import com.borisovskaya.reservation.repository.HotelsRepository;
import com.borisovskaya.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


}