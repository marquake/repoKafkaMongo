package com.mms.repartidor.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerRepartidorAlta extends KafkaMessage {

	public KafkaMessageConsumerRepartidorAlta() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_ALTA));
		new Thread(() -> pollMessages(consumer, TOPIC_ALTA)).start();
	}

}