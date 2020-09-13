package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CommonRepository<OrderStatus> {

    OrderStatus findByStatus(String status);
}
