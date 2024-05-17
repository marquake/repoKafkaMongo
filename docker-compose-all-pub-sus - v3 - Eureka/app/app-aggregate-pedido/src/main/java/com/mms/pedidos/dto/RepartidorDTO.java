package com.mms.pedidos.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepartidorDTO {
    private Long id;
    private String name;
    private String cod_repartidor;
}
