package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CommonRepository<Order> {

    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :status")
    List<Order> findAllByOrderStatus(@Param("status") OrderStatus status);

    @Query(value = "SELECT o FROM Order o WHERE o.trackingCode IS NOT NULL AND o.status = :status")
    List<Order> findAllDelivered(@Param("status") String status);

    @Query(value = "SELECT o FROM Order o WHERE o.trackingCode IS NOT NULL AND o.status NOT LIKE :status")
    List<Order> findAllInDeliveryButNotDelivered(@Param("status") String status);
}