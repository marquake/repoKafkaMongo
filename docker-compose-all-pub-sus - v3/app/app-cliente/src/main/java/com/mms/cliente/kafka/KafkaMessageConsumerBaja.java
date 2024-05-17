package com.mms.cliente.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumerBaja extends KafkaMessage {

	public KafkaMessageConsumerBaja() {
		super();
	}

//	//@PostConstruct
//	@KafkaListener
//	public void subscribe() {
//		consumer.subscribe(Arrays.asList(TOPIC_BAJA));
//		new Thread(() -> pollMessages(consumer, TOPIC_BAJA)).start();
//	}
//
//	KafkaCommon.to
//
//	@KafkaListener(topics = "topic-baja", groupId = "group_id", containerFactory = "kafkaListenerContainerFactoryBaja")
//	public void consume(String message) {
//		System.out.println("Mensaje recibido en topic-baja: " + message);
//	}
}