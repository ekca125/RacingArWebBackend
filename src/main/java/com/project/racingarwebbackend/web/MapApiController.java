package com.project.racingarwebbackend.web;

import com.google.gson.Gson;
import com.project.racingarwebbackend.service.map.MapService;
import com.project.racingarwebbackend.web.dto.AddressDto;
import com.project.racingarwebbackend.web.dto.MapRange;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/api/v1/address/id={id}")
    public AddressDto findById(@PathVariable long id) {
        return mapService.findById(id);
    }

    @GetMapping("/api/v1/address/draw/random")
    public AddressDto drawRandom() {
        return mapService.drawRandom();
    }

    @PostMapping("/api/v1/address/draw/range")
    public List<AddressDto> drawMapRangeAddress(@RequestBody String requestJson) {
        Gson gson = new Gson();
        MapRange mapRange = gson.fromJson(requestJson, MapRange.class);
        return mapService.drawMapRangeAddress(mapRange);
    }

    @PostMapping("/api/v1/address/draw/range-limit-10")
    public List<AddressDto> drawMapRangeAddress10(@RequestBody String requestJson) {
        Gson gson = new Gson();
        MapRange mapRange = gson.fromJson(requestJson, MapRange.class);
        return mapService.drawMapRangeAddressLimit(mapRange, 10);
    }

    @PostMapping("/api/v1/address/draw/range-limit-50")
    public List<AddressDto> drawMapRangeAddress50(@RequestBody String requestJson) {
        Gson gson = new Gson();
        MapRange mapRange = gson.fromJson(requestJson, MapRange.class);
        return mapService.drawMapRangeAddressLimit(mapRange, 50);
    }

    @PostMapping("/api/v1/address/draw/range-limit-100")
    public List<AddressDto> drawMapRangeAddress100(@RequestBody String requestJson) {
        Gson gson = new Gson();
        MapRange mapRange = gson.fromJson(requestJson, MapRange.class);
        return mapService.drawMapRangeAddressLimit(mapRange, 100);
    }
}
