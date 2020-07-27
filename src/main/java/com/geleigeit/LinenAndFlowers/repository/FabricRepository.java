package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FabricRepository extends CrudRepository<Fabric, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Fabric f set f.deletedAt = :delete where f.id = :id")
    void deleteFabric(@Param("delete") Date delete,
                      @Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Fabric f set f.length = :length, f.updatedAt = :update where f.id = :id")
    void updateFabric(@Param("length") int length,
                      @Param("update") Date update,
                      @Param("id") long id);

    List<Fabric> findAllByDeletedAtIsNull();
}
