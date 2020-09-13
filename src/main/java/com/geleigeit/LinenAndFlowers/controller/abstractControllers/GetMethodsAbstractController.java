package com.geleigeit.LinenAndFlowers.controller.abstractControllers;

import com.geleigeit.LinenAndFlowers.controller.interfaceControllers.GetMethodsController;
import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.CommonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

public abstract class GetMethodsAbstractController<E extends BaseEntity, S extends CommonService<E>>
        implements GetMethodsController<E> {

    private final S service;
    private static final Logger logger = LogManager.getLogger(GetMethodsController.class);

    @Autowired
    protected GetMethodsAbstractController(S service) {
        this.service = service;
    }

    public E getOne(long id) {
        final E e;
        try {
            e = service.getOne(id);
        } catch (NullPointerException exception) {
            logger.error("{} entity with id:{} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
        return e;
    }

    public Set<E> getAll() {
        try {
            return service.getAll();
        } catch (NotFoundException exception) {
            logger.error("no one entity found");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "no one entity found", exception);
        }
    }
}
