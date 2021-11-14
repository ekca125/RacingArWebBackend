package com.project.racingarwebbackend.service.map;

import com.project.racingarwebbackend.web.dto.MapFlagDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MapServiceTest {
    @Autowired
    private MapService mapService;

    @Test
    void findAddress() {
        assertThat(mapService.findAddress(1L).id()).isEqualTo(1L);
    }

    @Test
    void randomAddress() {
        mapService.randomAddress();
    }

    @Test
    void rangeAddress() {
        Double startLatitude = 35.0979529784;
        Double startLongitude = 129.0219886069;
        Double endLatitude = 35.1066801454;
        Double endLongitude = 129.0290353612;
        List<MapFlagDto> mapFlagDtoList = mapService.rangeAddress(startLatitude, startLongitude, endLatitude, endLongitude);
        assertThat(mapFlagDtoList.size()).isGreaterThan(1);
    }

    @Test
    void rangeRandomAddress() {
        Double startLatitude = 35.0979529784;
        Double startLongitude = 129.0219886069;
        Double endLatitude = 35.1066801454;
        Double endLongitude = 129.0290353612;
        long limit = 10;
        List<MapFlagDto> mapFlagDtoList = mapService.rangeRandomAddress(startLatitude, startLongitude, endLatitude, endLongitude, limit);
        assertThat(mapFlagDtoList.size()).isEqualTo(limit);
    }
}