package com.project.racingarwebbackend.service.map;

import com.google.gson.Gson;
import com.project.racingarwebbackend.domain.map.RoadAddress;
import com.project.racingarwebbackend.domain.map.RoadAddressRepository;
import com.project.racingarwebbackend.web.dto.AddressDto;
import com.project.racingarwebbackend.web.dto.MapRange;
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
    final static private int LIMIT_SIZE = 10000;

    public AddressDto findById(long id){
        RoadAddress roadAddress = roadAddressRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 존재하지 않습니다. id = " + id));
        return new AddressDto(roadAddress);
    }

    public AddressDto drawRandom() {
        long maxSize = roadAddressRepository.count() - 1;
        return findById(ThreadLocalRandom.current().nextLong(maxSize));
    }

    // 초기 가공
    public List<AddressDto> drawMapRangeAddress(MapRange mapRange){
        List<RoadAddress> addressList = roadAddressRepository.queryRange(
                mapRange.getStartLatitude(),
                mapRange.getStartLongitude(),
                mapRange.getEndLatitude(),
                mapRange.getEndLongitude());
        Collections.shuffle(addressList);
        return addressList
                .stream()
                .limit(LIMIT_SIZE)
                .map(AddressDto::new)
                .collect(Collectors.toList());
    }

    // 중간 가공
    public List<AddressDto> drawMapRangeAddressLimit(MapRange mapRange, int limit) {
        List<AddressDto> addressDtoList = drawMapRangeAddress(mapRange);
        Collections.shuffle(addressDtoList);
        return addressDtoList
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
