package com.example.demo;



import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange direct;

	String routingKey = "snax";

	String[]  list = {"s-sandwitches","s-pakora","l-biriyani","l-roti"};
	
		public void send() {
		int i =0;
		for(String message:list) {
		
			
			if(message.substring(0, 1).equalsIgnoreCase("l")) {
				this.routingKey="lunch";
			}
			
		template.convertAndSend(direct.getName(), this.routingKey, message.substring(2));
		    System.out.println(" Sent '" + message.substring(2) + "'");
		    
		    i++;
		}
	}

}
