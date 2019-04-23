package com.example.demo.resource;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/message")
public class ProducerResource {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	@GetMapping("/{message}")
	public String publish(@PathVariable("message") final String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "Message sent Succcessfully :: "+message;
	}
	
}
