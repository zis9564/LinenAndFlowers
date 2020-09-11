package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CommonRepository<Order> {

//    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :status")
//    List<Order> findAllByOrderStatus(@Param("status") long status);
//
//    @Query(value = "SELECT o FROM Order o WHERE o.trackingCode IS NOT NULL " +
//            "AND o.orderStatus = :status " +
//            "AND o.deliveryService = :deliveryService")
//    List <Order> findAllByOrderStatusAndDeliveryServiceWhereTrackingCodeIsNotNull(@Param("status") long status,
//                                                              @Param("deliveryService") long deliveryService);

    List<Order> findAllByOrderStatusIdAndDeliveryServiceId(long statusId, long deliveryServiceId);

}