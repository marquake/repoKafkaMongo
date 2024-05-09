package com.mms.pedidos.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaService {

    private static final String BOOTSTRAP_SERVERS = "http://kafka:9092";
    private static final String TOPIC_ALTA = "pedido-alta";
    private static final String TOPIC_BAJA = "pedido-baja";
    private static final String TOPIC_ASIGNAR = "pedido-asignar";
    private static final String TOPIC_FINALIZAR = "pedido-finalizar";

    // Realizo el envío enviando el productor y el dato.
    public static void sendMessageAlta(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_ALTA);
    }
    // Realizo el envío enviando el productor y el dato.
    public static void sendMessageBaja(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_BAJA);
    }
    public static void sendMessageAsignar(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_ASIGNAR);
    }
    public static void sendMessageFinalizar(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_FINALIZAR);
    }
    // Realizo el envío enviando el productor y el dato.
    public static void sendMessage(Producer<String, String> producer, String data, String topic) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, data);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Topic: " + metadata.topic() + ", offset: " + metadata.offset() + " -> data: " + data);
            } else {
                System.err.println("Error al enviar mensaje: " + exception.getMessage());
            }
        });
    }

    public static String objToString(Object objSerializable){
        String jsonDtoSerializado = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonDtoSerializado = objectMapper.writeValueAsString(objSerializable);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonDtoSerializado;
    }

    // Se crea el productor de Kafka y se le indica que la clave/valor van a ser Strings Serializadas.
    // Retorna el productor con las propiedades aplicadas.
    public static Producer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        return producer;
    }

}
