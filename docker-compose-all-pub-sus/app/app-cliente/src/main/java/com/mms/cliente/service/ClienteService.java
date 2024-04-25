package com.mms.cliente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public List<ClienteDTO> getListaClientes(){

        ClienteDTO c1 = ClienteDTO.builder().id(1L).name("pepe").build();
        ClienteDTO c2 = ClienteDTO.builder().id(2L).name("juan").build();

        return List.of(c1, c2);

    }
}
