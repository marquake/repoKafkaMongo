package com.mms.repartidor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
