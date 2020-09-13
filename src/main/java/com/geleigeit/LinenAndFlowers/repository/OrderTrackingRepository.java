package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderTrackingRepository extends CommonRepository<OrderTracking> {

    Set<OrderTracking> findAllByOrderId(long id) throws NullPointerException;
}
