package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Type t set t.deletedAt = :delete where t.id = :id")
    void deleteType(@Param("delete") Date delete,
                           @Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Type t set t.type = :type, t.fabrics = :fabrics, t.updatedAt = :update where t.id = :id")
    void updateType(@Param("type") String name,
                    @Param("fabrics") List<Fabric> fabrics,
                    @Param("update") Date update,
                    @Param("id") long id);

    List<Type> findAllByDeletedAtIsNull();
}
