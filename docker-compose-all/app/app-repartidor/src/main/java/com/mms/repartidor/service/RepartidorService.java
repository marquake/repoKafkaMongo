package com.mms.repartidor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartidorService {

    public List<RepartidorDTO> getListaRepartidores(){
        RepartidorDTO r1 = RepartidorDTO.builder()
                .id(1L).name("Scott").cod_repartidor("cod-r1").build();

        RepartidorDTO r2 = RepartidorDTO.builder()
                .id(1L).name("Jhon").cod_repartidor("cod-r2").build();

        return List.of(r1, r1);
    }
}
