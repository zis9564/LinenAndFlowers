package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends CommonRepository<Order> {

//    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :status")
//    Set<Order> findAllByOrderStatus(@Param("status") long status);

    Set<Order> findAllByOrderStatusIdAndDeliveryServiceId(long statusId, long deliveryServiceId);

    Order findByOrderStatusIdAndDeliveryServiceIdAndId(long statusId, long deliveryServiceId, long id);

    Set<Order> findAllByOrderStatusId(long id);
}