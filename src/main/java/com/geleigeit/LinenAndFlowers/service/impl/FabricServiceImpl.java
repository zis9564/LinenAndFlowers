package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import com.geleigeit.LinenAndFlowers.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//        if(fabric == null || fabric.getDeletedAt() != null) throw new NotFoundException();
//        if(fabric.getColour() != null) {
            Colour colour = fabric.getColour();
            colour.getFabrics().add(fabric);

//        } else {
//            throw new NotFoundException();
//        }
//        if(fabric.getType() != null) {
            Type type = fabric.getType();
            type.getFabrics().add(fabric);

//        } else {
//            throw new NotFoundException();
//        }
//        if(fabric.getThickness() != null) {
            Thickness thickness = fabric.getThickness();
            thickness.getFabrics().add(fabric);

//        } else {
//            throw new NotFoundException();
//        }
        return fabricRepository.save(fabric);
    }

    @Override
    @Transactional
    public Fabric getOne(long id) {
       return fabricRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}