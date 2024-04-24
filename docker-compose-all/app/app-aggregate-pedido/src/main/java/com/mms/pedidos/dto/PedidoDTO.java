package com.mms.pedidos;

import lombok.*;

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
