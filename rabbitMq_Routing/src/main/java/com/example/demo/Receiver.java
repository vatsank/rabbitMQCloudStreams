package com.example.demo;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Receiver {

	@RabbitListener(queues = "#{queue1.name}")
	public void receive1(String in) throws InterruptedException {
		receive(in, "snax");
	}

	@RabbitListener(queues = "#{queue2.name}")
	public void receive2(String in) throws InterruptedException {
		receive(in, "lunch");
	}

	public void receive(String in, String receiver) throws InterruptedException {
	
		System.out.println("instance " + receiver + " [x] Received '" + in + "'");
	}

	
	}


