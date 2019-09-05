package com.infy.tele.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Mongosvc11KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(Mongosvc11KafkaProducer.class);
    private static final String TOPIC = "topic_mongosvc11";

    private KafkaTemplate<String, String> kafkaTemplate;

    public Mongosvc11KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
