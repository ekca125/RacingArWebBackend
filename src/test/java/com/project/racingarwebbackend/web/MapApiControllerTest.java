package com.project.racingarwebbackend.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MapApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findAddress() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/address/id=1",
                String.class)).contains("latitude");
    }

    @Test
    void randomAddress() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/address/random",
                String.class)).contains("latitude");
    }

    @Test
    void rangeAddress() {
        Double startLatitude = 35.0979529784;
        Double startLongitude = 129.0219886069;
        Double endLatitude = 35.1066801454;
        Double endLongitude = 129.0290353612;

    }

    @Test
    void rangeAddressRandom() {
    }
}