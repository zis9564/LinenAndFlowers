package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ColourServiceImpl implements ColourService {

    private final ColourRepository colourRepository;

    @Autowired
    public ColourServiceImpl(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Override
    @Transactional
    public void addColour(Colour colour) {
        if(colour.getDeletedAt() != null) throw new NotFoundException();
        colourRepository.save(colour);
    }

    @Override
    @Transactional
    public Colour deleteColour(long id){
        Colour colour = colourRepository.findById(id).orElseThrow(NotFoundException::new);
        if(colour.getDeletedAt() != null) throw new NotFoundException();
        colour.setDeletedAt(new Date());
        return colourRepository.save(colour);
    }

    @Override
    @Transactional
    public Colour updateColour(Colour newColour) {
        Colour colour = getOne(newColour.getId());
        if(newColour.getColour() == null || colour.getDeletedAt() != null) throw new NotFoundException();

        colour.setColour(newColour.getColour());
        colour.setFabrics(newColour.getFabrics());
        colour.setUpdatedAt(new Date());
        return colourRepository.save(colour);
    }

    @Override
    @Transactional
    public Colour getOne(long id) {
        return colourRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public List<Colour> getAll() {
        List<Colour> colourList = colourRepository.findAllByDeletedAtIsNull();
        if(colourList.isEmpty()) {
            throw new NotFoundException();
        }
        return colourList;
    }
}