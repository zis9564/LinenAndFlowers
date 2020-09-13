package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.DeliveryService;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryServiceRepository extends CommonRepository<DeliveryService> {

    DeliveryService findByName(String name);
}
