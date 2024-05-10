package com.mms.cliente.service;

import com.mms.cliente.dto.ClienteDTO;
import com.mms.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDTO> getListaClientes(){
        ClienteDTO c1 = ClienteDTO.builder().id(1L).name("pepe").build();
        ClienteDTO c2 = ClienteDTO.builder().id(2L).name("juan").build();
        return List.of(c1, c2);
    }

    public void altaCliente(ClienteDTO clienteDTO){
//        KafkaService.sendMessageAlta(
//                KafkaService.createKafkaProducer(),
//                KafkaService.objToString(clienteDTO)
//        );

        clienteRepository.save(clienteDTO);
    }

    public void bajaCliente(Long idCliente){
//        KafkaService.sendMessageBaja(
//                KafkaService.createKafkaProducer(),
//                KafkaService.objToString(idCliente)
//        );
    }
}