package com.geleigeit.LinenAndFlowers.controller.abstractControllers;

import com.geleigeit.LinenAndFlowers.controller.interfaceControllers.AllMethodsController;
import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import com.geleigeit.LinenAndFlowers.service.CommonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AllMethodsAbstractController<E extends BaseEntity, S extends CommonService<E>>
        extends GetMethodsAbstractController<E, S>
        implements AllMethodsController<E> {

    private final S service;

    private static final Logger logger = LogManager.getLogger(AllMethodsAbstractController.class);

    protected AllMethodsAbstractController(S service) {
        super(service);
        this.service = service;
    }

    public void post(E e) {
        try {
            service.addOne(e);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "given entity is already exist", exception);
        }
    }

    public E put(E e) {
        try {
            return service.update(e);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some of fields doesn't match", exception);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "given entity is null", exception);
        }
    }

    public void remove(long id) {
        try {
            service.delete(id);
            logger.info("Entity {} id {} deleted", this, id);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Controller {} Entity id:{} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Entity with given id doesn't exist", exception);
        }
    }
}