package com.example.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerResource {
	
	@JmsListener(destination = "${activemq.queue.name}")
	public void consumeMessage(String message) {
		System.out.println("Message Received :: "+message);
	}
}
