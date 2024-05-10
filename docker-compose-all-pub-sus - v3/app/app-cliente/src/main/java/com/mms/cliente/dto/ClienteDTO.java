package com.mms.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "cliente")
public class ClienteDTO {

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
