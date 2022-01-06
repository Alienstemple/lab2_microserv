package com.borisovskaya.reservation.service;

import com.borisovskaya.reservation.model.Hotels;
import com.borisovskaya.reservation.model.HotelsResponse;
import com.borisovskaya.reservation.repository.HotelsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelsServiceImpl implements HotelsService{
    private final HotelsRepository hotelsRepository;

    public HotelsServiceImpl(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    @Override
    public Optional<Hotels>[] getHotelsList(Integer page, Integer size) {
        int hotelsCount = (int) hotelsRepository.count();
        Optional<Hotels>[] hotels = new Optional[size];

        for (int i = 0; i < size; i++) {
            int ind = (page - 1) * size + i;
            if (ind < hotelsCount)
                hotels[i] = hotelsRepository.findById(ind+1);
        }
       Optional<Hotels> hotel = hotelsRepository.findById(1);
//        for (int i = 0; i < size; i++) {
//            Integer id = 1;
//            hotels[i] = hotelsRepository.getById(id);
//        }
        return hotels;
    }

    @Override
    public Hotels checkUid(UUID hotelUid) {
            Hotels hotels = hotelsRepository.findByHotelUid(hotelUid);
            return hotels;
    }
}


