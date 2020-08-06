package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ColourRepository extends CrudRepository<Colour, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Colour c set c.deletedAt = :delete where c.id = :id")
    void deleteColour(@Param("delete") Date delete,
                      @Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Colour c set c.colour = :name, c.fabrics = :fabrics, c.updatedAt = :update where c.id = :id")
    void updateColour(@Param("name") String name,
                      @Param("fabrics") List<Fabric> fabrics,
                      @Param("update") Date update,
                      @Param("id") long id
    );

    List<Colour> findAllByDeletedAtIsNull();
}