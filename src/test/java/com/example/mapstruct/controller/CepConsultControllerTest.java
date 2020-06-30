package com.example.mapstruct.controller;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CepConsultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9001);

    @Test
    public void cepTest() throws Exception {
        wireMockRule.start();
        final MvcResult mvcResult = mockMvc
            .perform(MockMvcRequestBuilders.get("http://localhost:8080/consulta-ceps/{cep}", "38400322"))
            .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        wireMockRule.stop();
    }

}