package com.example.mapstruct.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class CepConsultControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private WireMockServer wireMockServer;

    @BeforeEach
    public void setUp() {
        this.wireMockServer = new WireMockServer(
                options()
                .port(9001)
        );
        wireMockServer.start();
    }

    @Test
    public void cepTest() throws Exception {
        final MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/consulta-ceps/{cep}", "38400322"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @AfterEach
    public void setDown() {
        this.wireMockServer.stop();
    }
}