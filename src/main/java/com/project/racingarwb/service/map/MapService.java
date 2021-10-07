package com.project.racingarwb.service.map;

import com.project.racingarwb.domain.map.RoadAddress;
import com.project.racingarwb.domain.map.RoadAddressRepository;
import com.project.racingarwb.web.dto.MapFlagDto;
import com.project.racingarwb.web.dto.MapRangeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class MapService {
    private final RoadAddressRepository roadAddressRepository;

    public MapFlagDto findById(Long id){
        RoadAddress entity = roadAddressRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = "+id));
        return new MapFlagDto(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }

    public MapFlagDto getRandomFlag(){
        Long count = roadAddressRepository.count();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        Long id = random.nextLong(count - 1);
        return findById(id);
    }

    public MapFlagDto getRandomFlagWithLatitudeLongitude(MapRangeRequestDto mapRangeRequestDto){
        List<RoadAddress> roadAddressList= roadAddressRepository.queryRange(
                        mapRangeRequestDto.getStartLatitude(),
                mapRangeRequestDto.getStartLongitude(),
                mapRangeRequestDto.getEndLatitude(),
                mapRangeRequestDto.getEndLongitude());
        roadAddressList= roadAddressRepository.queryRange(
                1.0,
                1.0,
                1000.0,
                1000.0);

        // size is 0 ->
        Collections.shuffle(roadAddressList);
        RoadAddress entity = roadAddressList.get(0);
        return new MapFlagDto(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude());
    }
}
