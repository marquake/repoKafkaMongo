package com.mms.repartidor.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerRepartidorCogePedido extends KafkaMessage {

	public KafkaMessageConsumerRepartidorCogePedido() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_COGE_PEDIDO));
		new Thread(() -> pollMessages(consumer, TOPIC_COGE_PEDIDO)).start();
	}

}