package com.example.mapstruct.usecase.feign;

import com.example.mapstruct.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep", url = "${url.consulta.cep}")
public interface CepService {

    @GetMapping(path = "/{cep}/json/")
    Address busca(@PathVariable("cep") String cep);
}
