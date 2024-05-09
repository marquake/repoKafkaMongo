package com.mms.pedidos.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDTO {
    private Long id;
    private Long idCliente;
    private Long idRepartidor;
}
