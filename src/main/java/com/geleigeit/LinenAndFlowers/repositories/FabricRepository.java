package com.geleigeit.LinenAndFlowers.repositories;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricRepository extends CrudRepository<Fabric, Long> {
}
