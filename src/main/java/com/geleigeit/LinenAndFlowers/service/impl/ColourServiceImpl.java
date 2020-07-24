package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ColourServiceImpl implements ColourService {

    @Autowired
    private ColourRepository colourRepository;

    @Override
    @Transactional
    public void addColour(Colour colour) {
        colourRepository.save(colour);
    }

    @Override
    @Transactional
    public void updateColour(String name, long id) {
        colourRepository.updateColour(name, id);
    }

    @Override
    @Transactional
    public void deleteColour(long id){
        colourRepository.deleteColour(id);
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
        return colourRepository.findAllByExistTrue();
    }
}