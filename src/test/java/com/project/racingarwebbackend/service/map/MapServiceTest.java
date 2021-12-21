package com.project.racingarwebbackend.service.map;

import com.project.racingarwebbackend.web.dto.AddressDto;
import com.project.racingarwebbackend.web.dto.MapRange;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MapServiceTest {
    @Autowired
    private MapService mapService;

    @Test
    void findById() {
        assertThat(mapService.findById(1L).getId()).isEqualTo(1L);
    }

    @Test
    void drawRandom() {
        AddressDto addressDto = mapService.drawRandom();
        assertThat(addressDto).isNotNull();
    }

    @Test
    void drawMapRangeAddress() {
        double startLatitude = 35.0979529784;
        double startLongitude = 129.0219886069;
        double endLatitude = 35.1066801454;
        double endLongitude = 129.0290353612;
        MapRange mapRange = MapRange.builder()
                .startLatitude(startLatitude)
                .startLongitude(startLongitude)
                .endLatitude(endLatitude)
                .endLongitude(endLongitude)
                .build();
        List<AddressDto> addressDtoList = mapService.drawMapRangeAddress(mapRange);
        assertThat(addressDtoList.size()).isGreaterThan(1);
    }

    @Test
    void drawMapRangeAddressLimit() {
        double startLatitude = 35.0979529784;
        double startLongitude = 129.0219886069;
        double endLatitude = 35.1066801454;
        double endLongitude = 129.0290353612;
        MapRange mapRange = MapRange.builder()
                .startLatitude(startLatitude)
                .startLongitude(startLongitude)
                .endLatitude(endLatitude)
                .endLongitude(endLongitude)
                .build();
        int limit = 10;
        List<AddressDto> addressDtoList = mapService.drawMapRangeAddressLimit(mapRange, 10);
        assertThat(addressDtoList.size()).isLessThanOrEqualTo(limit);
    }

}