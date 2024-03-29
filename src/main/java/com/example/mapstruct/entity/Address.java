package com.example.mapstruct.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {

    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final Integer ibge;
    private final String gia;
    private final String ddd;
    private final Integer siafi;

    private Address(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Integer ibge,
                    String gia, String ddd, Integer siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
