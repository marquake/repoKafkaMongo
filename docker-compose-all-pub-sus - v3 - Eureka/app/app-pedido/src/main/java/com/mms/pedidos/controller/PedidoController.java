package com.mms.pedidos.controller;

import com.mms.pedidos.dto.PedidoDTO;
import com.mms.pedidos.service.PedidoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //localhost:8082/pedido
    //{"id":1, "idCliente":3, "idRepartidor":6}
    @PostMapping(value = "/pedido", consumes = MediaType.ALL_VALUE)
    public void altaPedido(@RequestBody PedidoDTO pedidoDTO){
        pedidoService.altaPedido(pedidoDTO);
    }

    //localhost:8082/pedido/5
    @DeleteMapping(value = "/pedido/{idPedido}")
    public void bajaPedido(@PathVariable Long idPedido){
        pedidoService.bajaPedido(idPedido);
    }

    //localhost:8082/pedido-asignar
    //{"id":1, "idCliente":3, "idRepartidor":6}
    @PostMapping(value = "/pedido-asignar", consumes = MediaType.ALL_VALUE)
    public void asignarPedido(@RequestBody PedidoDTO pedidoDTO){
        pedidoService.asignarPedido(pedidoDTO);
    }

    //localhost:8082/pedido-finalizar
    //{"id":1, "idCliente":3, "idRepartidor":6}
    @PostMapping(value = "/pedido-finalizar", consumes = MediaType.ALL_VALUE)
    public void finalizarPedido(@RequestBody PedidoDTO pedidoDTO){
        pedidoService.finalizarPedido(pedidoDTO);
    }

}
