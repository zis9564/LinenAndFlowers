package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTrackingRepository extends CrudRepository<OrderTracking, Long> {

    @Query(value = "SELECT o FROM OrderTracking o WHERE o.trackingCode = :trackingCode ORDER BY current_date")
    List<OrderTracking> findAllByTrackingCode(@Param("trackingCode") String trackingCode);
}
