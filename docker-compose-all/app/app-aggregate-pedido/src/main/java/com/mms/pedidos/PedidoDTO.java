package com.mms.pedidos;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PedidoDTO {
    private Long id;
    private Long idCliente;
    private Long idRepartidor;
}
