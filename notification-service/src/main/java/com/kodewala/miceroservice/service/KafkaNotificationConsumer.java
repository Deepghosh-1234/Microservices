package com.kodewala.miceroservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaNotificationConsumer.class);

	@KafkaListener(topics = "order-notification", groupId = "notification-group")
	public void consume(String message) {

		log.info("Message received from Kafka: {}", message);

		String[] parts = message.split("\\|");

		String email = parts[0];
		String subject = parts[1];
		String body = parts[2];

		sendEmail(email, subject, body);
	}

	private void sendEmail(String email, String subject, String body) {
		try {
			log.info("Sending Email...");
			log.info("To: {}", email);
			log.info("Subject: {}", subject);
			log.info("Message: {}", body);
		} catch (Exception e) {
			log.error("failed to send email ", e);
		}

	}
}
