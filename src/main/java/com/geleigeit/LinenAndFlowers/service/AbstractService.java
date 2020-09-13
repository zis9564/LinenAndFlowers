package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import com.geleigeit.LinenAndFlowers.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public abstract class AbstractService<E extends BaseEntity,
                                        R extends CommonRepository<E>>
                                        implements CommonService<E> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Transactional
    public void addOne(E e) {
        if(repository.existsById(e.getId())) {
            throw new NullPointerException();
        } repository.save(e);
    }

    @Transactional
    public void delete(long id) {
        try {
            repository.deleteById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public E update(E newE){
        return repository.save(newE);
    }

    @Transactional
    public E getOne(long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public Set<E> getAll() {
        try{
            return repository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}