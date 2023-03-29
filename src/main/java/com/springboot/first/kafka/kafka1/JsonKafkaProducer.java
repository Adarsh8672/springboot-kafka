package com.springboot.first.kafka.kafka1;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springboot.first.kafka.payload.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}



	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent -> %s", data.toString()));
		ProducerRecord<String, User> record = new ProducerRecord<>("topic_first_json", data);
		kafkaTemplate.send(record);

	}
}
