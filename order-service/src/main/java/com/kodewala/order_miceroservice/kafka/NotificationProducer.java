package com.kodewala.order_miceroservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order-notification";


    public void sendNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message sent to Kafka: " + message);
    }

   
    public void sendNotification(String email, String subject, String message) {

        String payload = email + "|" + subject + "|" + message;

        kafkaTemplate.send(TOPIC, payload);

        System.out.println("Kafka Notification Sent: " + payload);
    }
}
