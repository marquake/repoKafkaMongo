package com.mms.cliente.controller;

import com.mms.cliente.dto.ClienteDTO;
import com.mms.cliente.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping(value="/cliente", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<List<ClienteDTO>> getListaClientes(){
        System.out.println("getListaClientes");
        return ResponseEntity.ok(clienteService.getListaClientes());
    }

    // esto lo hago para dar de alta clientes porque no puedo hacerlo por problemas con el
    // proxy de la ofi y el postman.
    @GetMapping(value="/cliente-alta/{id}/{name}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> getListaClientes(@PathVariable Long id, @PathVariable String name){
        System.out.println("getListaClientes");
        clienteService.altaCliente(ClienteDTO.builder().id(id).name(name).build());
        return ResponseEntity.accepted().body("");
    }

    @PostMapping(value="/cliente", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> altaClientes(@RequestBody ClienteDTO clienteDTO){
        System.out.println("altaClientes");
        clienteService.altaCliente(clienteDTO);
        return ResponseEntity.accepted().body("");
        //return ResponseEntity.ok(clienteService.getListaClientes());
    }

    @DeleteMapping(value="/cliente/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> bajaClientes(@PathVariable Long idCliente){
        System.out.println("bajaClientes: idCliente: " + idCliente);
        clienteService.bajaCliente(idCliente);
        return ResponseEntity.accepted().body("");
        //return ResponseEntity.ok(clienteService.getListaClientes());
    }

}