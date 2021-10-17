package com.example.mapstruct.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Localizacao {

    private String cidade;
    private String estado;
}
