package com.mms.pedidos.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerAsignar extends KafkaMessage{

	public KafkaMessageConsumerAsignar() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_ASIGNAR));
		new Thread(() -> pollMessages(consumer, TOPIC_ASIGNAR)).start();
	}

}