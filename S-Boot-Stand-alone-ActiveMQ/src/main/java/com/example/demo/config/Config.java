package com.example.demo.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	@Value("${activemq.queue.name}")
	private String queueName;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(queueName);
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(brokerUrl);
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}

}
