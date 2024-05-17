package com.mms.repartidor.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableKafka
@Component
public class KafkaMessageConsumerRepartidorEntregaPedido extends KafkaMessage {

	public KafkaMessageConsumerRepartidorEntregaPedido() {
		super();
	}

	@PostConstruct
	public void subscribe() {
		consumer.subscribe(Arrays.asList(TOPIC_ENTREGA_PEDIDO));
		new Thread(() -> pollMessages(consumer, TOPIC_ENTREGA_PEDIDO)).start();
	}

}