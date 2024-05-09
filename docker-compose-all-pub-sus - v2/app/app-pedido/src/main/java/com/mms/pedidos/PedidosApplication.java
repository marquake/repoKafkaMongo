package com.mms.pedidos;

import com.mms.pedidos.kafka.KafkaMessageConsumerAlta;
import com.mms.pedidos.kafka.KafkaMessageConsumerAsignar;
import com.mms.pedidos.kafka.KafkaMessageConsumerBaja;
import com.mms.pedidos.kafka.KafkaMessageConsumerFinalizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidosApplication {

	@Autowired
	KafkaMessageConsumerAlta kafkaMessageConsumerAlta;
	@Autowired
	KafkaMessageConsumerBaja kafkaMessageConsumerBaja;
	@Autowired
	KafkaMessageConsumerAsignar kafkaMessageConsumerAsignar;
	@Autowired
	KafkaMessageConsumerFinalizar kafkaMessageConsumerFinalizar;

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

}
