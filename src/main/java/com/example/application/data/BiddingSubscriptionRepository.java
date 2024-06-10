package com.example.application.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;


public interface BiddingSubscriptionRepository extends JpaRepository<BiddingSubscription, Long>, JpaSpecificationExecutor<BiddingSubscription> {

    Set<BiddingSubscription> findAllByUserId(Long user_id);
}