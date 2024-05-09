package com.mms.pedidos.service;

import com.mms.pedidos.dto.PedidoDTO;
import com.mms.pedidos.kafka.KafkaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    public List<PedidoDTO> getListaPedidos(){
        PedidoDTO p1 = PedidoDTO.builder()
                .id(1L).idCliente(1L).idRepartidor(1L).build();

        PedidoDTO p2 = PedidoDTO.builder()
                .id(2L).idCliente(2L).idRepartidor(2L).build();

        return List.of(p1, p2);
    }

    public void altaPedido(PedidoDTO pedidoDTO){
        KafkaService.sendMessageAlta(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(pedidoDTO)
        );
    }
    public void bajaPedido(Long idPedido){
        KafkaService.sendMessageBaja(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(idPedido)
        );
    }
    public void asignarPedido(PedidoDTO pedidoDTO){
        KafkaService.sendMessageAsignar(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(pedidoDTO)
        );
    }
    public void finalizarPedido(PedidoDTO pedidoDTO){
        KafkaService.sendMessageFinalizar(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(pedidoDTO)
        );
    }

}
