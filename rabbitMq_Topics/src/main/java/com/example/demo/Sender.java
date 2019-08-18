package com.example.demo;



import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange topic;


	String[]  message = {"idly","poori","dosa","roti","oothapam","chapathi"};

    private final String[] keys = {"south.breakfast.idly", "north.breakfast.poori", "south.breakfast.dosa",
            "north.lunch.roti", "north.breakfast.dosa", "south.lunch.roti"};



		public void send() {
		int i =0;
		for(String key:keys) {
		
			
			
		template.convertAndSend(topic.getName(), key, message[i]);
		    System.out.println(" Sent '" + message[i] + "  to := "+ key);
		    
		    try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    i++;
		}
	}

}
