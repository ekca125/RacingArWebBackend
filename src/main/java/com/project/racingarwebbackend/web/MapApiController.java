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
@RequestMapping(value = "/api/v1/address", method = {RequestMethod.GET, RequestMethod.POST})
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/id={id}")
    public AddressDto findById(@PathVariable long id) {
        return mapService.findById(id);
    }

    @GetMapping("/draw/random")
    public AddressDto drawRandom() {
        return mapService.drawRandom();
    }

    @PostMapping("/draw/range")
    public List<AddressDto> drawMapRangeAddress(@RequestBody MapRange mapRange) {
        return mapService.drawMapRangeAddress(mapRange);
    }

    @PostMapping("/draw/range-limit-10")
    public List<AddressDto> drawMapRangeAddress10(@RequestBody MapRange mapRange) {
        return mapService.drawMapRangeAddressLimit(mapRange, 10);
    }

    @PostMapping("/draw/range-limit-50")
    public List<AddressDto> drawMapRangeAddress50(@RequestBody MapRange mapRange) {
        return mapService.drawMapRangeAddressLimit(mapRange, 50);
    }

    @PostMapping("/draw/range-limit-100")
    public List<AddressDto> drawMapRangeAddress100(@RequestBody MapRange mapRange) {
        return mapService.drawMapRangeAddressLimit(mapRange, 100);
    }
}
