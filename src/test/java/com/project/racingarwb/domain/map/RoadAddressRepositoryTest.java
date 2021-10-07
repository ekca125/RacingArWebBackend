package com.project.racingarwb.domain.map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoadAddressRepositoryTest {

    @Autowired
    private RoadAddressRepository roadAddressRepository;

    @Test
    void findId() {
        RoadAddress entity = roadAddressRepository
                .findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = " + 1));
    }

    @Test
    void queryRange() {

    }
}