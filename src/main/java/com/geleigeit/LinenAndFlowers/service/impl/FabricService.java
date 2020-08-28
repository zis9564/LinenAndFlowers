package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NegativeValueException;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class FabricService extends AbstractService<Fabric, FabricRepository> {

    public FabricService(FabricRepository fabricRepository) {
        super(fabricRepository);
    }

    Logger logger = LogManager.getLogger(FabricService.class);

    @Override
    public Fabric update(Fabric newFabric) {
        Fabric fabric = getOne(newFabric.getId());
        fabric.setLength(newFabric.getLength());
        fabric.setColour(newFabric.getColour());
        fabric.setType(newFabric.getType());
        fabric.setThickness(newFabric.getThickness());
        logger.debug("fabric {} has updated", fabric.hashCode());
        repository.save(fabric);
        return getOne(newFabric.getId());
    }

    @Transactional
    public void updateFabricLength(Fabric fabric, int length) throws NegativeValueException {
        int newLength = fabric.getLength() - length;
        Long id = fabric.getId();
        if(newLength < 0) {
            logger.error("${fabric.fabricLength.negativeValue}");
            throw new NegativeValueException();
        } else {
            repository.updateFabricLength(newLength, id);
            logger.debug("fabricLength has changed");
        }
    }

    @Transactional
    public List<Fabric> getAllFabricsWithSmallLength() {
        return repository.findFabricByLength();
    }
}