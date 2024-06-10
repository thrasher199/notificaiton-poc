package com.example.application.configuration;

import com.example.application.data.Bidding;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Bean
    ConsumerFactory<BiddingKey, BiddingValue> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "group");
        properties.put("enable.auto.commit", false);
        properties.put("auto.commit.interval.ms", "10");
        properties.put("session.timeout.ms", "60000");
        ErrorHandlingDeserializer<BiddingValue> errorHandlingDeserializer
                = new ErrorHandlingDeserializer<>(new JsonDeserializer<>(BiddingValue.class));
        return new DefaultKafkaConsumerFactory<>(properties, new JsonDeserializer<>(BiddingKey.class), errorHandlingDeserializer);
    }

    @Bean
    KafkaListenerContainerFactory<?> kafkaListenerContainerFactory(ConsumerFactory<BiddingKey, BiddingValue> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<BiddingKey, BiddingValue> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConcurrency(2);
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return kafkaListenerContainerFactory;
    }
}
