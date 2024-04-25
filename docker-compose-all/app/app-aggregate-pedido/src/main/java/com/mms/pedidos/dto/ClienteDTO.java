package com.mms.pedidos.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {
    private Long id;
    private String name;
}
