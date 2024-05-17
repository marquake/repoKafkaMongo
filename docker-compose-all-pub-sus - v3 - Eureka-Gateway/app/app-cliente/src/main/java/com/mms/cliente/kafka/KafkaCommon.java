package com.mms.cliente.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public interface KafkaCommon {

    final String BOOTSTRAP_SERVERS = "http://kafka:9092";
    final String TOPIC_ALTA = "cliente-alta";
    final String TOPIC_BAJA = "cliente-baja";

    @Value("${topic.group.id}")
    final String GROUP_ID = "";

    final Long TIEMPO_POLLING = 100L;
}