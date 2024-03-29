package com.infy.tele.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Mongosvc11KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(Mongosvc11KafkaConsumer.class);
    private static final String TOPIC = "topic_mongosvc11";

    @KafkaListener(topics = "topic_mongosvc11", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
