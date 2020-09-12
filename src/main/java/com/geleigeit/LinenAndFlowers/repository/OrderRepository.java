package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CommonRepository<Order> {

    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :status")
    List<Order> findAllByOrderStatus(@Param("status") long status);

    List<Order> findAllByOrderStatusIdAndDeliveryServiceId(long statusId, long deliveryServiceId);

    Order findByOrderStatusIdAndDeliveryServiceIdAndId(long statusId, long deliveryServiceId, long id);

    List<Order> findAllByOrderStatusId(long id);
}