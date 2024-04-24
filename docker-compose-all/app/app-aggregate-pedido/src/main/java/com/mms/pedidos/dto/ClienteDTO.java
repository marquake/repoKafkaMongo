package com.mms.cliente;

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
