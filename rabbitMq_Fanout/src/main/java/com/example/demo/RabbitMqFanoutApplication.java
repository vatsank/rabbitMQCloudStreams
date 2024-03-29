package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RabbitMqFanoutApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(RabbitMqFanoutApplication.class, args);
	
		 Sender sender = ctx.getBean(Sender.class);
		 
		 sender.send();
	}

	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("example.fanout");
	}


		@Bean
		public Queue queue1() {
			return new AnonymousQueue();
		}

		@Bean
		public Queue queue2() {
			return new AnonymousQueue();
		}

		@Bean
		public Binding binding1(FanoutExchange fanout, Queue queue1) {
			return BindingBuilder.bind(queue1).to(fanout);
		}

		@Bean
		public Binding binding2(FanoutExchange fanout, Queue queue2) {
			return BindingBuilder.bind(queue2).to(fanout);
		}

		@Bean
		public Receiver receiver() {
			return new Receiver();
		}


}
