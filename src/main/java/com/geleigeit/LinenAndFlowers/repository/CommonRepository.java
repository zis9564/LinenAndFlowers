package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity> extends CrudRepository<E, Long> {

    Set<E> findAll() throws NullPointerException;
}