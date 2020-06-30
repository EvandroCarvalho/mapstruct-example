package com.example.mapstruct.controller;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControllerTest {

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
        .downloadStub("com.example", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
        .withPort(9001)
        .stubsMode(StubsMode.LOCAL);

    @Test
    public void get() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:9001/38400322/json/",
            String.class);

        BDDAssertions.then(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
