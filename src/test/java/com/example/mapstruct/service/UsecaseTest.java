package com.example.mapstruct.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mapstruct.dto.BeerDtoV2;
import com.example.mapstruct.entity.Beer;
import com.example.mapstruct.mapper.BeerMapper;
import com.example.mapstruct.mapper.BeerMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(MockitoExtension.class)
class UsecaseTest {

    @InjectMocks
    Usecase usecase;

    @Spy
    BeerMapper beerMapper = new BeerMapperImpl();

    @Test
    public void usercaseTest(){
        BeerDtoV2 beerDtoV2 = BeerDtoV2.builder().beerName("beer test").build();

        final Beer beer = usecase.to(beerDtoV2);

        System.out.println(beer.getBeerName());

    }

}