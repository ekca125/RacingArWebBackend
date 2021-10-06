package com.project.racingarwb.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MapFlagDto {
    private final Long id;
    private final Double latitude;
    private final Double longitude;
}
