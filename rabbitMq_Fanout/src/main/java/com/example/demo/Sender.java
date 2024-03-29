package com.example.demo;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private FanoutExchange fanout;

	String[]  list = {"sandwitches","pakora","biriyani","roti"};
	
   
		public void send() {
		String routingKey = "";
		
		for(String message:list) {
		template.convertAndSend(fanout.getName(), routingKey, message);
		    System.out.println(" Sent '" + message + "'");
		    
		    try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
