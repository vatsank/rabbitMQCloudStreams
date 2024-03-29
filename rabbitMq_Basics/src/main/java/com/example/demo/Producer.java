package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.amqp.core.Queue;


public class Producer {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {
		String message = "Hello World!";
		this.template.convertAndSend(queue.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}

}
