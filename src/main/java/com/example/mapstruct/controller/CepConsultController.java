package com.example.mapstruct.controller;

import com.example.mapstruct.usecase.feign.CepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/consulta-ceps")
public class CepConsultController {

    private final CepService cepService;

    public CepConsultController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping(path = "/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String consulta(@PathVariable("cep") String cep) {

        return cepService.busca(cep);

    }
}
