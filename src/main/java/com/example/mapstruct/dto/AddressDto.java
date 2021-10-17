package com.example.mapstruct.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddressDto {

    private final String cep;
    private final String rua;
    private final String complemento;
    private final String bairro;
//    private final String cidade;
//    private final String estado;
    private final String ddd;
    private final Localizacao localizacao;


}
