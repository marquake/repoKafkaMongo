package com.mms.cliente;

import com.mms.cliente.kafka.KafkaMessageConsumerBaja;
import com.mms.cliente.kafka.KafkaMessageConsumerAlta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteApplication {

	static KafkaMessageConsumerBaja kafkaMessageConsumerBaja;

	static KafkaMessageConsumerAlta kafkaMessageConsumerAlta;

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
}