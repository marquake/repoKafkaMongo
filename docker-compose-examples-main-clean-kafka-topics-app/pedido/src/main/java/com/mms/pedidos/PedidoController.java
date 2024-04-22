package com.mms.pedidos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService =  pedidoService;
    }

    @GetMapping(value ="/pedido")
    public ResponseEntity<List<PedidoDTO>> getListaPedidos(){
        return ResponseEntity.ok(pedidoService.getListaPedidos());
    }
}
