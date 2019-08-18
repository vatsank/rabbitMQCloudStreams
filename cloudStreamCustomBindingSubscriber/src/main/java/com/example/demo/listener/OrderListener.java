package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.OrderSink;
import com.example.demo.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(OrderSink.class)
public class OrderListener
{

    @StreamListener(target = OrderSink.INPUT)
    public void listenForOrder(Order order)
    {
     log.info(" received new order ["+order.toString()+"] ");
    }
}
