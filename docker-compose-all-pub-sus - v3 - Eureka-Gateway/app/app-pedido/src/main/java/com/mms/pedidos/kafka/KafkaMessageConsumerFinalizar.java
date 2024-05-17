package com.mms.pedidos.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerFinalizar extends KafkaMessage{

	public KafkaMessageConsumerFinalizar() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_FINALIZAR));
		new Thread(() -> pollMessages(consumer, TOPIC_FINALIZAR)).start();
	}

}