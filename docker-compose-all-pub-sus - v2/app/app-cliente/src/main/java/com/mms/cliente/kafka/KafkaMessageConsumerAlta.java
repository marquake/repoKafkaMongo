package com.mms.cliente.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerAlta extends KafkaMessage{

	public KafkaMessageConsumerAlta() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_ALTA));
		new Thread(() -> pollMessages(consumer, TOPIC_ALTA)).start();
	}

}