package com.mms.cliente.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mms.cliente.dto.ClienteDTO;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

@Service
public class ClienteService {

    private static final String BOOTSTRAP_SERVERS = "http://kafka:9092";
    private static final String TOPIC = "cliente-alta";

    public List<ClienteDTO> getListaClientes(){

        publicarCola();
        //publicarColaString();

        ClienteDTO c1 = ClienteDTO.builder().id(1L).name("pepe").build();
        ClienteDTO c2 = ClienteDTO.builder().id(2L).name("juan").build();

        return List.of(c1, c2);

    }

    public void publicarCola(){
        System.out.println("publicarCola(): INICIO");
        Producer<String, String> kafkaProducer = createKafkaProducer();
        //ClienteDTO data = generateData();
        String data = generateDataString();
        sendMessage(kafkaProducer, data);
        System.out.println("publicarCola(): FIN");
    }

//    public void publicarColaString(){
//        System.out.println("publicarColaString(): INICIO");
//        Producer<String, String> kafkaProducer = createKafkaProducerString();
//        String data = generateDataString();
//        sendMessageString(kafkaProducer, data);
//        System.out.println("publicarColaString(): FIN");
//    }


//    // Voy a generar identificadores aleatorios para escribir en la cola.
//        private static ClienteDTO generateData() {
//            ClienteDTO c1 = ClienteDTO.builder().id(1L).name("pepe").build();
//            System.out.println("generateData(): c1: " + c1);
//            //return UUID.randomUUID().toString();
//            return c1;
//    }

    // Voy a generar identificadores aleatorios para escribir en la cola.
    private static String generateDataString() {

        ClienteDTO c1 = ClienteDTO.builder().id(1L).name("pepe").build();
        System.out.println("generateData(): c1: " + c1);

        ObjectMapper objectMapper = new ObjectMapper();

        // Serializar el objeto ClienteDTO a JSON
        String jsonClienteDTO = "";
        try {
            jsonClienteDTO = objectMapper.writeValueAsString(c1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonClienteDTO;
    }

    // Se crea el productor de Kafka y se le indica que la clave/valor van a ser Strings Serializadas.
    // Retorna el productor con las propiedades aplicadas.
    private static Producer<String, String> createKafkaProducer() {
        System.out.println("createKafkaProducer()...");

        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //props.put("value.serializer", "org.apache.kafka.common.serialization.JsonSerializer");
        //props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        System.out.println("createKafkaProducer(): producer: " + producer);

        return producer;
    }


//    // Se crea el productor de Kafka y se le indica que la clave/valor van a ser Strings Serializadas.
//    // Retorna el productor con las propiedades aplicadas.
//    private static Producer<String, String> createKafkaProducerString() {
//        System.out.println("createKafkaProducerString()...");
//        Properties props = new Properties();
//        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        Producer<String, String> producer = new KafkaProducer<>(props);
//        System.out.println("createKafkaProducerString(): producer: " + producer);
//
//        return producer;
//    }


    // Realizo el envío enviando el productor y el dato.
    private static void sendMessage(Producer<String, String> producer, String data) {

        System.out.println("sendMessage()...");
        System.out.println("sendMessage(): producer: " + producer);
        System.out.println("sendMessage(): data: " + data);

        // Genero un ProducerRecord "registro producido", y con el producer hago el send.
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, data);

        // Hago el envío, esto me retornará el FutureRecord<Metadata>, del que saco los datos
        // que me ha devuelto el broker.
        System.out.println("data(UsuarioDTO): " + data);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Topic: " + metadata.topic() + ", offset: " + metadata.offset() + " -> data: " + data);
            } else {
                System.err.println("Error al enviar mensaje: " + exception.getMessage());
            }
        });
    }

//    // Realizo el envío enviando el productor y el dato.
//    private static void sendMessageString(Producer<String, String> producer, String data) {
//
//        System.out.println("sendMessageString()...");
//        System.out.println("sendMessageString(): producer: " + producer);
//        System.out.println("sendMessageString(): data: " + data);
//
//        // Genero un ProducerRecord "registro producido", y con el producer hago el send.
//        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, data);
//
//        // Hago el envío, esto me retornará el FutureRecord<Metadata>, del que saco los datos
//        // que me ha devuelto el broker.
//        System.out.println("data(String): " + data);
//        producer.send(record, (metadata, exception) -> {
//            if (exception == null) {
//                System.out.println("Topic: " + metadata.topic() + ", offset: " + metadata.offset() + " -> data: " + data);
//            } else {
//                System.err.println("Error al enviar mensaje: " + exception.getMessage());
//            }
//        });
//    }

}
