package com.springboot.first.kafka.kafka1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.first.kafka.payload.User;
@Service
public class JsonKafkaConsumer {

	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics = "topic_first_json",groupId = "myGroup")
	public void consume(User user) {
 LOGGER.info(String.format("Message received : %s", user.toString()));
	}
}
