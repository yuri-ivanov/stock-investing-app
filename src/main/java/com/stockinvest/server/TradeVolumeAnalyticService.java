package com.stockinvest.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeAnaliticService {
    Logger log = LoggerFactory.getLogger(TradeAnaliticService.class);
    //private final GreetingsStreams greetingsStreams;

    @Autowired
    private KafkaTemplate<String, Greetings> kafkaTemplate;

    public TradeAnaliticService(/*GreetingsStreams greetingsStreams*/) {
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
