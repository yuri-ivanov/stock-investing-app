package com.stockinvest.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TradeVolumeAnalyticService {
    Logger log = LoggerFactory.getLogger(TradeVolumeAnalyticService.class);
    //private final GreetingsStreams greetingsStreams;

    @Value("${kafka.topic.stocks.bigvolume}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, BigVolumeMessage> kafkaTemplate;

    public TradeVolumeAnalyticService(/*GreetingsStreams greetingsStreams*/) {
        //this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(final BigVolumeMessage greetings) {
        log.info("Sending greetings {}", greetings);
        /*MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
                */
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(greetings));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topic, greetings);
    }
}
