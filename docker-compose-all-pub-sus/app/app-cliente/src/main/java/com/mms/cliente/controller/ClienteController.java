package com.mms.cliente.controller;

import com.mms.cliente.dto.ClienteDTO;
import com.mms.cliente.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping(value="/cliente")
    public ResponseEntity<List<ClienteDTO>> getListaClientes(){
        return ResponseEntity.ok(clienteService.getListaClientes());
    }

}
