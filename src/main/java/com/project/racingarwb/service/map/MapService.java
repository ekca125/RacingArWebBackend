package com.project.racingarwb.service.map;

import com.project.racingarwb.domain.map.RoadAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MapService {
    private final RoadAddressRepository roadAddressRepository;


}
