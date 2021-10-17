package com.example.mapstruct.mapper;


import com.example.mapstruct.dto.AddressDto;
import com.example.mapstruct.dto.Localizacao;
import com.example.mapstruct.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "logradouro", target = "rua")
    @Mapping(source = ".", target = "localizacao")
    AddressDto from(Address address);

    @Mapping(source = "localidade", target = "cidade")
    @Mapping(source = "uf", target = "estado")
    Localizacao toLocalizacao(Address address);
}
