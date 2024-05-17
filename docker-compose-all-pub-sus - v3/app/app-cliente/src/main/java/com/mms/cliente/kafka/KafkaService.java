package com.mms.cliente.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaService implements KafkaCommon {

    // Realizo el envío enviando el productor y el dato.
    public static void sendMessageAlta(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_ALTA);
    }

    // Realizo el envío enviando el productor y el dato.
    public static void sendMessageBaja(Producer<String, String> producer, String data) {
        sendMessage(producer, data, TOPIC_BAJA);
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

    // Método para deserializar un JSON a un objeto de tipo ClienteDTO
    public static <T> T stringToObj(String jsonString, Class<T> claseT) {
        T clienteDTO = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            clienteDTO = objectMapper.readValue(jsonString, claseT);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return clienteDTO;
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
