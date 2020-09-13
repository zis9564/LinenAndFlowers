package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FabricRepository extends CommonRepository<Fabric> {

    @Query("SELECT f FROM Fabric f WHERE f.length < 300 ORDER BY f.id")
    Set<Fabric> findFabricByLength();

}