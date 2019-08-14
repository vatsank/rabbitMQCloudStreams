package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

   

//    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        CustomMessage  message = new CustomMessage("Hello there!", new Random().nextInt(50), false);
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMqMessageFormattterApplication.EXCHANGE_NAME, 
        		            RabbitMqMessageFormattterApplication.ROUTING_KEY, message);
    }
}

