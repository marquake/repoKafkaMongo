package com.mms.cliente.service;

import com.mms.cliente.dto.ClienteDTO;
import com.mms.cliente.kafka.KafkaService;
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
        KafkaService.sendMessageAlta(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(clienteDTO)
        );
    }

    public void bajaCliente(Long idCliente){
        KafkaService.sendMessageBaja(
                KafkaService.createKafkaProducer(),
                KafkaService.objToString(idCliente)
        );
    }

    public void procesarMensajeAlta(String mensaje) {
        ClienteDTO clienteDTO = KafkaService.stringToObj(mensaje, ClienteDTO.class);
        clienteRepository.save(clienteDTO);
    }

    public void procesarMensajeBaja(String mensaje) {
        Long id = KafkaService.stringToObj(mensaje, Long.class);
        clienteRepository.deleteById(id);
    }
}