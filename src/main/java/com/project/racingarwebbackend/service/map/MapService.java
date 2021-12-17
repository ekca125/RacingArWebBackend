package com.project.racingarwebbackend.service.map;

import com.project.racingarwebbackend.domain.map.RoadAddress;
import com.project.racingarwebbackend.domain.map.RoadAddressRepository;
import com.project.racingarwebbackend.web.dto.MapFlagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MapService {
    final private RoadAddressRepository roadAddressRepository;

    public MapFlagDto findAddress(Long id) {
        RoadAddress entity = roadAddressRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = " + id));
        return new MapFlagDto(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }

    public MapFlagDto randomAddress() {
        long maxSize = roadAddressRepository.count() - 1;
        return findAddress(ThreadLocalRandom.current().nextLong(maxSize));
    }
    
    //최대 10000건으로 제한
    public List<MapFlagDto> rangeAddress(Double startLatitude, Double startLongitude, Double endLatitude, Double endLongitude) {
        List<RoadAddress> addressList = roadAddressRepository.queryRange(startLatitude, startLongitude, endLatitude, endLongitude);
        Collections.shuffle(addressList);
        return addressList
                .stream()
                .map((entity) -> new MapFlagDto(
                        entity.getId(),
                        entity.getLatitude(),
                        entity.getLongitude()
                ))
                .limit(10000)
                .collect(Collectors.toList());
    }

    public List<MapFlagDto> rangeRandomAddress(Double startLatitude, Double startLongitude, Double endLatitude, Double endLongitude, long limit) {
        List<MapFlagDto> mapFlagDtoList = rangeAddress(startLatitude, startLongitude, endLatitude, endLongitude);
        Collections.shuffle(mapFlagDtoList);

        return mapFlagDtoList.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
