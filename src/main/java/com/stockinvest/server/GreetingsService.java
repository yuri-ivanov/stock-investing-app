package com.stockinvest.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class GreetingsService {
    Logger log = LoggerFactory.getLogger(GreetingsService.class);
    //private final GreetingsStreams greetingsStreams;

    @Autowired
    private KafkaTemplate<String, Greetings> kafkaTemplate;

    public GreetingsService(/*GreetingsStreams greetingsStreams*/) {
        //this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}", greetings);
        /*MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
                */
        kafkaTemplate.send("boot.greetings", greetings);
    }
}
