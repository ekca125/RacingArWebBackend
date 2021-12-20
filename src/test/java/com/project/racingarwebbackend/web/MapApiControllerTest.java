package com.project.racingarwebbackend.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MapApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findAddress() {

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

        String url = "http://localhost:" + port + "/api/v1/address/range";
        Map<String, Double> param = new HashMap<>();
        param.put("startLatitude",startLatitude);
        param.put("startLongitude",startLongitude);
        param.put("endLatitude",endLatitude);
        param.put("endLongitude",endLongitude);

        String response = this.restTemplate.postForEntity(url,param,String.class).toString();
        assertThat(response).contains("latitude");
    }

    @Test
    void rangeAddressRandom() {
        Double startLatitude = 35.0979529784;
        Double startLongitude = 129.0219886069;
        Double endLatitude = 35.1066801454;
        Double endLongitude = 129.0290353612;
        long limit = 10;

        String url = "http://localhost:" + port + "/api/v1/address/range-random";
        Map<String, Double> param = new HashMap<>();
        param.put("startLatitude",startLatitude);
        param.put("startLongitude",startLongitude);
        param.put("endLatitude",endLatitude);
        param.put("endLongitude",endLongitude);
        param.put("limit", (double) limit);

        String response = this.restTemplate.postForEntity(url,param,String.class).toString();
        assertThat(response).contains("latitude");
    }

    @Test
    void findById() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/address/id=1",
                String.class)).contains("latitude");
    }

    @Test
    void drawRandom() {
    }

    @Test
    void drawMapRangeAddress() {
    }

    @Test
    void drawMapRangeAddress10() {
    }

    @Test
    void drawMapRangeAddress50() {
    }

    @Test
    void drawMapRangeAddress100() {
    }
}