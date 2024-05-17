package com.mms.cliente.kafka;

import com.mms.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumerAlta extends KafkaMessage {

	@Value("${topic.group.id}")
	private final String GROUP_ID = "";

	ClienteService clienteService;

	public KafkaMessageConsumerAlta(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}	

	@KafkaListener(topics = TOPIC_ALTA, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactoryAlta")
	public void consume(String message) {
		clienteService.procesarMensajeAlta(message);
	}
}