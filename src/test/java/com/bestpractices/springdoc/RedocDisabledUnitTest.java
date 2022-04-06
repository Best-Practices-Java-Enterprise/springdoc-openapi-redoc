package com.bestpractices.springdoc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(properties = {"application.redoc.enabled=false", "application.openapi.enabled=true"})
class RedocDisabledUnitTest {

    @Autowired
    MockMvc mockMvc;

    @SneakyThrows
    @Test
    void redocPageShouldReturnNotFoundStatus() {
        mockMvc.perform(get(UTConstants.REDOC_URL)).andExpect(status().isNotFound());
    }

}
