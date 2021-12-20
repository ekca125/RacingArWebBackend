package com.project.racingarwebbackend.web.dto;

import com.project.racingarwebbackend.domain.map.RoadAddress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AddressDto {
    long id;
    double latitude;
    double longitude;

    @Builder
    public AddressDto(long id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AddressDto(RoadAddress roadAddress){
        this.id = roadAddress.getId();
        this.latitude = roadAddress.getLatitude();
        this.longitude = roadAddress.getLongitude();
    }
}
