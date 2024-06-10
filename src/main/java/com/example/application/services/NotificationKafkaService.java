package com.example.application.services;

import com.example.application.configuration.BiddingKey;
import com.example.application.configuration.BiddingValue;
import com.example.application.data.Bidding;
import com.example.application.data.BiddingSubscription;
import com.example.application.data.BiddingSubscriptionRepository;
import com.example.application.data.UserRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NotificationKafkaService {

    private final NotificationService notificationService;
    private final BiddingSubscriptionRepository biddingSubscriptionRepository;
    private final UserRepository userRepository;

    public NotificationKafkaService(NotificationService notificationService, BiddingSubscriptionRepository biddingSubscriptionRepository, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.biddingSubscriptionRepository = biddingSubscriptionRepository;
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "notification_topic", groupId = "bid_group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeKafka(ConsumerRecord<BiddingKey, BiddingValue> consumerRecord){
        /*String username = authentication.getName();
        Long userId = userRepository.findByUsername(username).getId();
        Set<BiddingSubscription> biddingSubscriptionSet = biddingSubscriptionRepository.findAllByUserId(userId);*/

        /*biddingSubscriptionSet.forEach(x -> {
           *//* if(x.getTopic().contains(consumerRecord.topic()))
                notificationService.publishNotification(consumerRecord.value());*//*

        });*/

        notificationService.publishNotification("Company:" + consumerRecord.value().getCompanyName()
                + " Bid Amount:" + consumerRecord.value().getBidAmount());
    }
}
