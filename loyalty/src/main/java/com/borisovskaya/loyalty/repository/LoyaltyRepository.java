package com.borisovskaya.loyalty.repository;

import com.borisovskaya.loyalty.model.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface LoyaltyRepository extends JpaRepository<Loyalty, Integer> {
    Loyalty findByUsername(String username);
}


