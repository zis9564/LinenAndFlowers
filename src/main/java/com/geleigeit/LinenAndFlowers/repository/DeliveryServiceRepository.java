package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.DeliveryService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryServiceRepository extends CrudRepository<DeliveryService, Long> {

    DeliveryService findByName(String name);
}
