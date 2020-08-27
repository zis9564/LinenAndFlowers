package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricRepository extends CommonRepository<Fabric> {

    @Modifying
    @Query("update Fabric f set f.length = :newLength where f.id = :id")
    void updateFabricLength(@Param("newLength") int newLength, @Param("id") Long id);

    @Query("SELECT f FROM Fabric f WHERE f.length < 300 ORDER BY f.id")
    List<Fabric> findFabricByLength();

}