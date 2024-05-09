package com.mms.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
