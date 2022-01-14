package com.borisovskaya.reservation.service;

import com.borisovskaya.reservation.model.Hotels;
import com.borisovskaya.reservation.repository.HotelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelsServiceImpl implements HotelsService{
    private final HotelsRepository hotelsRepository;

    public HotelsServiceImpl(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    @Override
    public List<Hotels> getHotelsList(Integer page, Integer size) {
        return hotelsRepository.findAll();
    }

    @Override
    public Hotels checkUid(String hotelUid) {
            Hotels hotels = hotelsRepository.findByHotelUid(hotelUid);
            return hotels;
    }
}


