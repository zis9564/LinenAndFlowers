package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.CommonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractService<E extends AbstractEntity,
                                        R extends CommonRepository<E>>
                                        implements CommonService<E> {

    private static final Logger logger = LogManager.getLogger(AbstractService.class);

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Transactional
    public void addOne(E e) {
        repository.save(e);
    }

    @Transactional
    public void delete(long id) {
            repository.deleteById(id);
    }

    @Transactional
    public E update(E newE){
//        E e = getOne(newE.getId());
        return repository.save(newE);
    }

    @Transactional
    public E getOne(long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<E> getAll() {
        List<E> eList = (List<E>) repository.findAll();
        if(eList.isEmpty()) {
            throw new NotFoundException();
        }
        return eList;
    }
}