package com.mms.repartidor.service;

import com.mms.repartidor.dto.RepartidorDTO;
import com.mms.repartidor.dto.CogePedidoDTO;
import com.mms.repartidor.kafka.KafkaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartidorService {

    public List<RepartidorDTO> getListaRepartidores(){
        RepartidorDTO r1 = RepartidorDTO.builder()
                .id(1L).name("Scott").cod_repartidor("cod-r1").build();

        RepartidorDTO r2 = RepartidorDTO.builder()
                .id(1L).name("Jhon").cod_repartidor("cod-r2").build();

        return List.of(r1, r1);
    }

    public void altaRepartidor(RepartidorDTO repartidor){
        KafkaService.sendMessageAlta(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(repartidor)
        );
    }

    public void bajaRepartidor(Long idRepartridor){
        KafkaService.sendMessageBaja(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(idRepartridor)
        );
    }

    public void cogerPedidoRepartidor(CogePedidoDTO cogePedidoDTO){
        KafkaService.sendMessageCogePedido(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(cogePedidoDTO)
        );
    }

    public void entregarPedidoRepartidor(CogePedidoDTO entregaPedidoDTO){
        KafkaService.sendMessageEntregaPedido(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(entregaPedidoDTO)
        );
    }

}