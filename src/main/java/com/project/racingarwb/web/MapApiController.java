package com.project.racingarwb.web;

import com.project.racingarwb.service.map.MapService;
import com.project.racingarwb.web.dto.MapFlagDto;
import com.project.racingarwb.web.dto.MapRangeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/api/v1/address/{id}")
    public MapFlagDto findById(@PathVariable Long id) {
        return mapService.findById(id);
    }

    @GetMapping("/api/v1/address/random")
    public MapFlagDto getRandomFlag() {
        return mapService.getRandomFlag();
    }

    @PostMapping("/api/v1/address/randomWithLatitudeLongitude")
    public MapFlagDto getRandomFlagWithLatitudeLongitude(MapRangeRequestDto mapRangeRequestDto) {
        return mapService.getRandomFlagWithLatitudeLongitude(mapRangeRequestDto);
    }
}
