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

    @GetMapping("/api/v1/address/find/id={id}")
    public MapFlagDto find(@PathVariable Long id) {
        return mapService.find(id);
    }

    @GetMapping("/api/v1/address/sampleFlag")
    public MapFlagDto sampleFlag() {
        return mapService.sampleFlag();
    }

    @PostMapping("/api/v1/address/rangeMap")
    public List<MapFlagDto> mapFlag(@RequestBody Map<String, Double> param) {
        Double startLatitude = param.get("startLatitude");
        Double startLongitude = param.get("startLongitude");
        Double endLatitude = param.get("endLatitude");
        Double endLongitude = param.get("endLongitude");
        return mapService.mapFlag(startLatitude, startLongitude, endLatitude, endLongitude);
    }

    @PostMapping("/api/v1/address/randomFlag10")
    public List<MapFlagDto> randomFlag10(@RequestBody Map<String, Double> param) {
        Double startLatitude = param.get("startLatitude");
        Double startLongitude = param.get("startLongitude");
        Double endLatitude = param.get("endLatitude");
        Double endLongitude = param.get("endLongitude");
        return mapService.randomMap(startLatitude, startLongitude, endLatitude, endLongitude, 10);
    }
}
