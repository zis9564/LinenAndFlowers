package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.util.ColourUtil;
import com.geleigeit.LinenAndFlowers.entity.util.FabricUtil;
import com.geleigeit.LinenAndFlowers.entity.util.ThicknessUtil;
import com.geleigeit.LinenAndFlowers.entity.util.TypeUtil;
import com.geleigeit.LinenAndFlowers.repositories.FabricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FabricServiceImpl {

    @Autowired
    private FabricRepository fabricsRepository;

    //works
    @Transactional
    public void addFabric(String colourName, String typeName, int thick) {

        Fabric fabric = FabricUtil.createFabric();
        fabric.setColour(ColourUtil.createColour(colourName));
        fabric.setType(TypeUtil.createType(typeName));
        fabric.setThickness(ThicknessUtil.createThickness(thick));
        fabricsRepository.save(fabric);
    }

    @Transactional
    public void deleteFabric(Long id) {
        fabricsRepository.deleteById(id);
    }

    //works
    @Transactional
    public Optional<Fabric> getFabric(Long id) {
        return fabricsRepository.findById(id);
    }

    //works
    @Transactional
    public Iterable<Fabric> getAll() {
        return fabricsRepository.findAll();
    }
}