package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import org.springframework.stereotype.Service;

@Service
public class FabricService extends AbstractService<Fabric, FabricRepository> {

    public FabricService(FabricRepository fabricRepository) {
        super(fabricRepository);
    }

    @Override
    public Fabric update(Fabric newFabric) {
        Fabric fabric = getOne(newFabric.getId());
        fabric.setLength(newFabric.getLength());
        fabric.setColour(newFabric.getColour());
        fabric.setType(newFabric.getType());
        fabric.setThickness(newFabric.getThickness());
        return repository.save(fabric);
    }
}