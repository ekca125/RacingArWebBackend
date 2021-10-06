package com.project.racingarwb.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findByIdJsonMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/address/findById/1",
                String.class)).contains("latitude");
    }

    @Test
    public void getRandomFlagJsonMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/address/getRandomFlag",
                String.class)).contains("latitude");
    }
}
