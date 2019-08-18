package com.example.demo;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqRoutingApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx =SpringApplication.run(RabbitMqRoutingApplication.class, args);
		
		 Sender sender = ctx.getBean(Sender.class);
		 
		 sender.send();

	}

	@Bean
	public DirectExchange direct() {
		return new DirectExchange("example.direct");
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
		public Binding binding1(DirectExchange direct, Queue queue1) {
			return BindingBuilder.bind(queue1).to(direct).with("snax");
		}

		@Bean
		public Binding binding2(DirectExchange direct, Queue queue2) {
			return BindingBuilder.bind(queue2).to(direct).with("lunch");
		}

		@Bean
		public Receiver receiver() {
			return new Receiver();
		}


}
