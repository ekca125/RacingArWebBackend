package com.project.racingarwebbackend.service.map;

import com.project.racingarwebbackend.domain.map.RoadAddress;
import com.project.racingarwebbackend.domain.map.RoadAddressRepository;
import com.project.racingarwebbackend.web.dto.MapFlagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MapService {
    private final RoadAddressRepository roadAddressRepository;

    public MapFlagDto find(Long id) {
        RoadAddress entity = roadAddressRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = " + id));
        return new MapFlagDto(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }

    public MapFlagDto sampleFlag() {
        Long count = roadAddressRepository.count();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        Long id = random.nextLong();
        return find(id);
    }

    public List<MapFlagDto> mapFlag(Double startLatitude, Double startLongitude, Double endLatitude, Double endLongitude) {
        return roadAddressRepository.queryRange(startLatitude, startLongitude, endLatitude, endLongitude)
                .stream()
                .map((entity) -> new MapFlagDto(
                        entity.getId(),
                        entity.getLatitude(),
                        entity.getLongitude()
                ))
                .collect(Collectors.toList());
    }

    public List<MapFlagDto> randomMap(Double startLatitude, Double startLongitude, Double endLatitude, Double endLongitude, long limit) {
        List<MapFlagDto> mapFlagDtoList = mapFlag(startLatitude, startLongitude, endLatitude, endLongitude);
        Collections.shuffle(mapFlagDtoList);

        return mapFlagDtoList.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
