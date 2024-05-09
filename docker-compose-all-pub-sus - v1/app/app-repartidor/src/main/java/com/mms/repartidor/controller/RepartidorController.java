package com.mms.repartidor.controller;

import com.mms.repartidor.dto.CogePedidoDTO;
import com.mms.repartidor.dto.RepartidorDTO;
import com.mms.repartidor.kafka.KafkaService;
import com.mms.repartidor.service.RepartidorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepartidorController {

    RepartidorService repartidorService;

    private RepartidorController(RepartidorService repartidorService){
        this.repartidorService = repartidorService;
    }

    @GetMapping(value = "/repartidor")
    private ResponseEntity<List<RepartidorDTO>> getListaRepartidores(){
        return ResponseEntity.ok(repartidorService.getListaRepartidores());
    }

    // localhost:8084/repartidor
    // {"id":4, "name":"juan", "cod_repartidor":"r4"}
    @PostMapping(value="/repartidor", consumes = MediaType.ALL_VALUE)
    public void altaRepartidor(@RequestBody RepartidorDTO repartidor){
        repartidorService.altaRepartidor(repartidor);
    }

    // localhost:8084/repartidor/8
    @DeleteMapping(value="/repartidor/{idRepartridor}", consumes = MediaType.ALL_VALUE)
    public void bajaRepartidor(@PathVariable Long idRepartridor){
        repartidorService.bajaRepartidor(idRepartridor);
    }

    // localhost:8084/repartidor/8
    // {"idRepartidor":4, "idPedido":3, "idCliente":1}
    @PostMapping(value="/repartidor-coger-pedido", consumes = MediaType.ALL_VALUE)
    public void cogerPedidoRepartidor(@RequestBody CogePedidoDTO cogePedidoDTO){
        repartidorService.cogerPedidoRepartidor(cogePedidoDTO);
    }

    // localhost:8084/repartidor/8
    // {"idRepartidor":4, "idPedido":3, "idCliente":1}
    @PostMapping(value="/repartidor-entregar-pedido", consumes = MediaType.ALL_VALUE)
    public void entregarPedidoRepartidor(@RequestBody CogePedidoDTO entregaPedidoDTO){
        repartidorService.entregarPedidoRepartidor(entregaPedidoDTO);
    }

}
