package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ThicknessRepository extends CrudRepository<Thickness, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Thickness t set t.deletedAt = :delete where t.id = :id")
    void deleteThickness(@Param("delete") Date delete,
                                @Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Thickness t set t.thickness = :thickness, t.fabrics = :fabrics, t.updatedAt = :update where t.id = :id")
    void updateThickness(@Param("thickness") int thickness,
                                @Param("fabrics") List<Fabric> fabrics,
                                @Param("update") Date update,
                                @Param("id") long id);

    List<Thickness> findAllByDeletedAtIsNull();
}
