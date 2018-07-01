package com.stockinvest.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class GreetingsListener {
    private static final Logger log = LoggerFactory.getLogger(GreetingsListener.class);
    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch(){
        return latch;
    }
/*
    @KafkaListener(topics = "${kafka.topic.boot}")
    public void handleGreetings(Greetings consumerRecord) {
        log.info("Received greetings: {}", consumerRecord.getMessage());
        latch.countDown();
    }
*/

}
