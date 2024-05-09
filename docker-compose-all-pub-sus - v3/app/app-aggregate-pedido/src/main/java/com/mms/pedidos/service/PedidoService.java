package com.mms.pedidos.service;

import com.mms.pedidos.dto.PedidoDTO;
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

}
