package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends CrudRepository<Colour, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Colour c set c.exist = false where c.id = :id")
    public void deleteColour(@Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Colour c set c.colour = :name where c.id = :id")
    public void updateColour(@Param("name") String name,
                      @Param("id") long id);
}