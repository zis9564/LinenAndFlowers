package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThicknessRepository extends CrudRepository<Thickness, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Thickness t set t.exist = false where t.id = :id")
    public void deleteThickness(@Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Thickness t set t.thickness = :thickness where t.id = :id")
    public void updateThickness(@Param("thickness") int thickness,
                             @Param("id") long id);

    public List<Thickness> findAllByExistTrue();
}
