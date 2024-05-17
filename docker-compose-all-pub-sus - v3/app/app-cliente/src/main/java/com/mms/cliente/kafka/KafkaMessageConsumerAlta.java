package com.mms.cliente.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumerAlta extends KafkaMessage{

	public KafkaMessageConsumerAlta() {
		super();
	}

//	@PostConstruct
//	public void subscribe() {
//		//consumer.subscribe(Arrays.asList(TOPIC_ALTA));
//		consumer.subscribe(List.of(TOPIC_ALTA));
//		new Thread(() -> pollMessages(consumer, TOPIC_ALTA)).start();
//	}

	//groupIdCliente
	//@KafkaListener(topics = TOPIC_ALTA, groupId = groupId, containerFactory = "kafkaListenerContainerFactoryAlta")
	@KafkaListener(topics = TOPIC_ALTA, groupId = "groupIdCliente", containerFactory = "kafkaListenerContainerFactoryAlta")
	public void consume(String message) {
		System.out.println("Mensaje recibido en topic-alta: " + message);
	}
}