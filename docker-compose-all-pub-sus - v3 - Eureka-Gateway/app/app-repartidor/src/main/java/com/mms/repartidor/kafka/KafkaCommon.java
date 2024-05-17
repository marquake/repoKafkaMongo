package com.mms.repartidor.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public interface KafkaCommon {

    static final String BOOTSTRAP_SERVERS = "http://kafka:9092";

    static final String TOPIC_ALTA = "repartidor-alta";
    static final String TOPIC_BAJA = "repartidor-baja";
    static final String TOPIC_COGE_PEDIDO = "repartidor-coge-pedido";
    static final String TOPIC_ENTREGA_PEDIDO = "repartidor-entrega-pedido";

    @Value("${topic.group.id}")
    final String groupId = "";

    final Long TIEMPO_POLLING = 100L;
}