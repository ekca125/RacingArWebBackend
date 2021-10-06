package com.project.racingarwb.web;

import com.project.racingarwb.web.dto.MapFlagDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class MapApiControllerTest {

    @Autowired
    private MapApiController mapApiController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mapApiController).isNotNull();
    }

}