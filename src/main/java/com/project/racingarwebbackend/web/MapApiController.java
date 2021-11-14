package com.project.racingarwebbackend.web;

import com.project.racingarwebbackend.service.map.MapService;
import com.project.racingarwebbackend.web.dto.MapFlagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/api/v1/address/id={id}")
    public MapFlagDto findAddress(@PathVariable Long id) {
        return mapService.findAddress(id);
    }

    @GetMapping("/api/v1/address/random")
    public MapFlagDto randomAddress() {
        return mapService.randomAddress();
    }

    @PostMapping("/api/v1/address/range")
    public List<MapFlagDto> rangeAddress(@RequestBody Map<String, Double> param) {
        Double startLatitude = param.get("startLatitude");
        Double startLongitude = param.get("startLongitude");
        Double endLatitude = param.get("endLatitude");
        Double endLongitude = param.get("endLongitude");
        return mapService.rangeAddress(startLatitude, startLongitude, endLatitude, endLongitude);
    }

    @PostMapping("/api/v1/address/range-random")
    public List<MapFlagDto> rangeAddressRandom(@RequestBody Map<String, Double> param) {
        Double startLatitude = param.get("startLatitude");
        Double startLongitude = param.get("startLongitude");
        Double endLatitude = param.get("endLatitude");
        Double endLongitude = param.get("endLongitude");
        Long limit = param.get("limit").longValue();
        return mapService.rangeRandomAddress(startLatitude, startLongitude, endLatitude, endLongitude, limit);
    }
}
