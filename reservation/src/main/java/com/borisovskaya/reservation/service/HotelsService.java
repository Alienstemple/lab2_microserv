package com.borisovskaya.reservation.service;

import com.borisovskaya.reservation.model.Hotels;
import com.borisovskaya.reservation.model.HotelsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface HotelsService {
    Optional<Hotels>[] getHotelsList(Integer page, Integer size);
    Hotels checkUid(UUID hotelUid);
}
