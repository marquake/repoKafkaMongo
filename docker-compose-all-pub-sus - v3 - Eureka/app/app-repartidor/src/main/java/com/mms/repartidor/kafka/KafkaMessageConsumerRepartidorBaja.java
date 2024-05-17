package com.mms.repartidor.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerRepartidorBaja extends KafkaMessage {

	public KafkaMessageConsumerRepartidorBaja() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_BAJA));
		new Thread(() -> pollMessages(consumer, TOPIC_BAJA)).start();
	}

}