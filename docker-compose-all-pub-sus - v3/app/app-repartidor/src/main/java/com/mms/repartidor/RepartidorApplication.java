package com.mms.repartidor;

import com.mms.repartidor.kafka.KafkaMessageConsumerRepartidorAlta;
import com.mms.repartidor.kafka.KafkaMessageConsumerRepartidorBaja;
import com.mms.repartidor.kafka.KafkaMessageConsumerRepartidorCogePedido;
import com.mms.repartidor.kafka.KafkaMessageConsumerRepartidorEntregaPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepartidorApplication {

	@Autowired
	static KafkaMessageConsumerRepartidorBaja kafkaMessageConsumerRepartidorBaja;

	@Autowired
	static KafkaMessageConsumerRepartidorAlta kafkaMessageConsumerRepartidorAlta;

	@Autowired
	static KafkaMessageConsumerRepartidorCogePedido kafkaMessageConsumerRepartidorCogePedido;

	@Autowired
	static KafkaMessageConsumerRepartidorEntregaPedido kafkaMessageConsumerRepartidorEntregaPedido;

	public static void main(String[] args) {
		SpringApplication.run(RepartidorApplication.class, args);
	}

}
