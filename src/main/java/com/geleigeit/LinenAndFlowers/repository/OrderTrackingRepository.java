package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTrackingRepository extends CommonRepository<OrderTracking> {

//    @Query(value = "SELECT o FROM OrderTracking o WHERE o.trackingCode = :trackingCode ORDER BY current_date")
//    Set<OrderTracking> findAllByTrackingCode(@Param("trackingCode") String trackingCode);
}
