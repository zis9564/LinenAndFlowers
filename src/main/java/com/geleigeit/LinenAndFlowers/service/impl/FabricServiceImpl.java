package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import com.geleigeit.LinenAndFlowers.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FabricServiceImpl implements FabricService {

    private final FabricRepository fabricRepository;

    @Autowired
    public FabricServiceImpl(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }

    @Override
    @Transactional
    public Fabric addFabric(Fabric fabric) {
        if(fabric == null
                || fabric.getColour() == null
                || fabric.getType() == null
                || fabric.getThickness() == null
        ) throw new RuntimeException();
        return fabricRepository.save(fabric);
    }

    @Override
    @Transactional
    public Fabric deleteFabric(long id) {
        Fabric fabric = fabricRepository.findById(id).orElseThrow(NotFoundException::new);
        if(fabric.getDeletedAt() != null) throw new NotFoundException();
        fabric.setDeletedAt(new Date());
        return fabricRepository.save(fabric);
    }

    @Override
    @Transactional
    public Fabric updateFabric(Fabric newFabric) {
        if(newFabric == null
                || newFabric.getColour() == null
                || newFabric.getType() == null
                || newFabric.getThickness() == null
        ) throw new RuntimeException();
        Fabric fabric = fabricRepository.findById(newFabric.getId()).orElseThrow(NotFoundException::new);
        if(fabric.getDeletedAt() != null) throw new NotFoundException();
        fabric.setLength(newFabric.getLength());
        fabric.setColour(newFabric.getColour());
        fabric.setType(newFabric.getType());
        fabric.setThickness(newFabric.getThickness());
        fabric.setUpdatedAt(new Date());
        return fabricRepository.save(fabric);
    }

    @Override
    @Transactional
    public Fabric getOne(long id) {
       return fabricRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public List<Fabric> getAllFabrics() {
        List<Fabric> fabricList = fabricRepository.findAllByDeletedAtIsNull();
        if(fabricList.isEmpty()) throw new NotFoundException();
        return fabricList;
    }
}