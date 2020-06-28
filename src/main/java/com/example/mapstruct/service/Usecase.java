package com.example.mapstruct.service;

import com.example.mapstruct.dto.BeerDtoV2;
import com.example.mapstruct.entity.Beer;
import com.example.mapstruct.mapper.BeerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Usecase {

    private final BeerMapper mapper;


    public Beer to(BeerDtoV2 beerDtoV2) {
        return  mapper.beerDtoToBeer(beerDtoV2);
    }
}
