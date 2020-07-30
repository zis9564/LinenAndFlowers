package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        colourRepository.save(colour);
    }

    @Override
    @Transactional
    public void updateColour(String name, long id) {
        Date update = new Date();
        colourRepository.updateColour(name, update, id);
    }

    @Override
    @Transactional
    public void deleteColour(long id){
        Date delete = new Date();
        colourRepository.deleteColour(delete, id);
    }

    @Override
    @Transactional
    public Colour getOne(long id) {
        Optional<Colour> colour = colourRepository.findById(id);
        if(colour.isPresent()) {
            try {
                return colour.get();
            } catch (NullPointerException e) {
                System.out.println("colour doesn't exist");
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<Colour> getAll() {
        return colourRepository.findAllByDeletedAtIsNull();
    }
}