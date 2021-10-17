package com.example.mapstruct.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Localizacao {

    private final String cidade;
    private final String estado;
}
