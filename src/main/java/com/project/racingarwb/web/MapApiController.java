package com.project.racingarwb.web;

import com.project.racingarwb.service.map.MapService;
import com.project.racingarwb.web.dto.MapFlagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/api/v1/address/findById/{id}")
    public MapFlagDto findById(@PathVariable Long id){
        return mapService.findById(id);
    }

    @GetMapping("/api/v1/address/getRandomFlag")
    public MapFlagDto getRandomFlag(){
        return mapService.getRandomFlag();
    }
}
