package com.project.racingarweb.web;

import com.project.racingarweb.web.dto.MapFlagDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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