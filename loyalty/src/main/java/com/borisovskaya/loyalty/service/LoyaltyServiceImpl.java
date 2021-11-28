package com.borisovskaya.loyalty.service;

import com.borisovskaya.loyalty.model.Loyalty;
import com.borisovskaya.loyalty.model.LoyaltyResponse;
import com.borisovskaya.loyalty.repository.LoyaltyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LoyaltyServiceImpl implements LoyaltyService {
    private final LoyaltyRepository loyaltyRepository;

    public LoyaltyServiceImpl(LoyaltyRepository loyaltyRepository) {
        this.loyaltyRepository = loyaltyRepository;
    }

    @Override
    public LoyaltyResponse getLoyalty(String username) {
        Loyalty loyalty = loyaltyRepository.findByUsername(username);
                //.orElseThrow(EntityNotFoundException::new);    // TODO: impl entity not found
        return new LoyaltyResponse(loyalty.getStatus(), loyalty.getDiscount(), loyalty.getReservationCount());
    }

    @Override
    public LoyaltyResponse incrementReservCount(String username) {
        Loyalty user = loyaltyRepository.findByUsername(username);
                                        //.orElseThrow(EntityNotFoundException::new);    // TODO: impl entity not found
        user.setReservationCount(user.getReservationCount()+1);
        if (user.getReservationCount() == 10) {
            user.setStatus("SILVER");
            user.setDiscount(7);
        }
        if (user.getReservationCount() == 20) {
            user.setStatus("GOLD");
            user.setDiscount(10);
        }
        Loyalty newuUser = loyaltyRepository.save(user);
        return new LoyaltyResponse(newuUser.getStatus(), newuUser.getDiscount(), newuUser.getReservationCount());
    }

    @Override
    public LoyaltyResponse decrementReservCount(String username) {
        Loyalty user = loyaltyRepository.findByUsername(username);
        //.orElseThrow(EntityNotFoundException::new);    // TODO: impl entity not found
        user.setReservationCount(user.getReservationCount()-1);
        if (user.getReservationCount() == 9) {
            user.setStatus("BRONZE");
            user.setDiscount(5);
        }
        if (user.getReservationCount() == 19) {
            user.setStatus("SILVER");
            user.setDiscount(7);
        }
        Loyalty newuUser = loyaltyRepository.save(user);
        return new LoyaltyResponse(newuUser.getStatus(), newuUser.getDiscount(), newuUser.getReservationCount());
    }
}