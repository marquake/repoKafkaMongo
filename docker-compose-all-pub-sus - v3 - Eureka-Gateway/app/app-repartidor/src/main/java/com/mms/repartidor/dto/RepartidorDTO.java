package com.mms.repartidor.dto;

import lombok.*;

@Data
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
