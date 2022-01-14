package com.borisovskaya.reservation.service;

import com.borisovskaya.reservation.model.Hotels;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface HotelsService {
    List<Hotels> getHotelsList(Integer page, Integer size);
    Hotels checkUid(String hotelUid);
}
