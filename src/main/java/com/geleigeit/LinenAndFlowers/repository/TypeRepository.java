package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {

    @Modifying(flushAutomatically = true)
    @Query("update Type t set t.exist = false where t.id = :id")
    public void deleteType(@Param("id") long id);

    @Modifying(flushAutomatically = true)
    @Query("update Type t set t.type = :name where t.id = :id")
    public void updateType(@Param("name") String name,
                             @Param("id") long id);

    public List<Type> findAllByExistTrue();
}
