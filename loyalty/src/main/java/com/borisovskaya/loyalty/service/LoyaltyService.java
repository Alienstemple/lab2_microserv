package com.borisovskaya.loyalty.service;

import com.borisovskaya.loyalty.model.Loyalty;
import com.borisovskaya.loyalty.model.LoyaltyResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoyaltyService {
    LoyaltyResponse getLoyalty(String username);
    LoyaltyResponse incrementReservCount(String username);
    LoyaltyResponse decrementReservCount(String username);
}