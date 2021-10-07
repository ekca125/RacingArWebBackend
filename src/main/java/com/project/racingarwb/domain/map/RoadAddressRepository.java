package com.project.racingarwb.domain.map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoadAddressRepository extends JpaRepository<RoadAddress, Long> {
    @Query("SELECT r FROM RoadAddress r WHERE " +
            "r.latitude BETWEEN :startLatitude AND :endLatitude AND " +
            "r.longitude BETWEEN :startLongitude AND :endLongitude")
    List<RoadAddress> queryRange(@Param("startLatitude") Double startLatitude,
                                 @Param("startLongitude") Double startLongitude,
                                 @Param("endLatitude") Double endLatitude,
                                 @Param("endLongitude") Double endLongitude);
}
