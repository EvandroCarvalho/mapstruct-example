package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.BeerDtoV2;
import com.example.mapstruct.entity.Beer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BeerMapper {

    BeerDtoV2 beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDtoV2 beerDtoV2);

}
