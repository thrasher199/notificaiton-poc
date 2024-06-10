package com.example.application.services;

import com.example.application.data.BiddingSubscription;
import com.example.application.data.BiddingSubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final BiddingSubscriptionRepository biddingSubscriptionRepository;

    public SubscriptionService(BiddingSubscriptionRepository biddingSubscriptionRepository) {
        this.biddingSubscriptionRepository = biddingSubscriptionRepository;
    }

    public void subscribe(String userId, String topic){

    }
}
