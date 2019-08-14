package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RabbitMqBasicsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(RabbitMqBasicsApplication.class, args);
		
		   Producer sender = ctx.getBean(Producer.class);
		   
		   sender.send();
		   
		   
	}
	
	@Bean
	public Queue hello() {
		return new Queue("hello");
	}

	@Bean
	public Receiver receiver() {
		return new Receiver();
	}

	@Bean
	public Producer sender() {
		return new Producer();
	}


}
