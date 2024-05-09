package com.mms.pedidos.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public interface KafkaCommon {

    final String BOOTSTRAP_SERVERS = "http://kafka:9092";
    static final String TOPIC_ALTA = "pedido-alta";
    static final String TOPIC_BAJA = "pedido-baja";
    static final String TOPIC_ASIGNAR = "pedido-asignar";
    static final String TOPIC_FINALIZAR = "pedido-finalizar";

    @Value("${topic.group.id}")
    final String groupId = "";

    final Long TIEMPO_POLLING = 100L;
}