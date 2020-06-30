package com.example.mapstruct.usecase.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep", url = "${url.consulta.cep}")
public interface CepService {

    @GetMapping(path = "/{cep}/json/")
    String busca(@PathVariable("cep") String cep);
}
