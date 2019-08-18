package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderSink
{
    String INPUT = "orderReceiveChannel";

    @Input(INPUT)
    SubscribableChannel receive();
}
