package com.project.racingarwb.domain.map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoadAddressRepository extends JpaRepository<RoadAddress, Long> {
    @Query("SELECT r FROM RoadAddress r WHERE r.latitude BETWEEN 35.0979529784 AND 35.1066801454 AND r.longitude BETWEEN 129.0219886069 AND 129.0290353612")
    List<RoadAddress> queryRange(@Param("startLatitude") Double startLatitude,
                                 @Param("startLongitude") Double startLongitude,
                                 @Param("endLatitude") Double endLatitude,
                                 @Param("endLongitude") Double endLongitude);
}
