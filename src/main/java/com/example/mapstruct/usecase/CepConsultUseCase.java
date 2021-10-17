package com.example.mapstruct.usecase;

import com.example.mapstruct.entity.Address;
import com.example.mapstruct.usecase.feign.CepService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaCepUseCase {
    private final CepService cepService;

    public ConsultaCepUseCase(CepService cepService) {
        this.cepService = cepService;
    }

    public Address busca(String cep) {
        return cepService.busca(cep);
    }
}
