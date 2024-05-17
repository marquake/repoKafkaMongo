package com.mms.cliente.kafka;

import com.mms.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumerBaja extends KafkaMessage {

	@Value("${topic.group.id}")
	private final String GROUP_ID = "";

	ClienteService clienteService;

	public KafkaMessageConsumerBaja(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@KafkaListener(topics = TOPIC_BAJA, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactoryBaja")
	public void consume(String message) {
		clienteService.procesarMensajeBaja(message);
	}

}