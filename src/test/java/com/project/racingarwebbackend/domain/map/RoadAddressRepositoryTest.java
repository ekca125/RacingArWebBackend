package com.project.racingarwebbackend.domain.map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RoadAddressRepositoryTest {

    @Autowired
    private RoadAddressRepository roadAddressRepository;

    @Test
    void findId() throws Exception {
        RoadAddress entity = roadAddressRepository
                .findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = " + 1));
    }

    @Test
    void testCount() throws Exception {
        Long count = roadAddressRepository.count();
        assertThat(count).isGreaterThan(1L);
    }

    @Test
    void testQueryMapRange() {
        Double startLatitude = 35.0979529784;
        Double startLongitude = 129.0219886069;
        Double endLatitude = 35.1066801454;
        Double endLongitude = 129.0290353612;

        var roadAddressList = roadAddressRepository.queryRange(
                startLatitude,
                startLongitude,
                endLatitude,
                endLongitude);

        assertThat((long) roadAddressList.size()).isGreaterThan(1L);
    }
}