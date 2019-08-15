package com.example.demo.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;

@Slf4j
@EnableBinding(Source.class)
@RestController
public class OrderController {

    @Autowired
    private Source source;

    @PostMapping("/orders/publish")
    public String publishOrder(@RequestBody Order order)
    {
        source.output().send(MessageBuilder.withPayload(order).build());
        log.info(order.toString());
        return "order_published";
    }

}
