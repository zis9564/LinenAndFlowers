package com.geleigeit.LinenAndFlowers.validator.annotationProvider;

import com.geleigeit.LinenAndFlowers.validator.annotations.AlreadyExist;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlreadyExistValidator implements ConstraintValidator<AlreadyExist, Colour> {

    private final ColourRepository colourRepository;

    @Autowired
    public AlreadyExistValidator(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Override
    public boolean isValid(Colour colour, ConstraintValidatorContext ctx) {
//        String colourName = colourRepository.findByColour(colour.getColour()).getColour();
//        return colourName == null;
        try {
            colourRepository.findByColour(colour.getColour());
        } catch (NotFoundException exception) {
            return true;
        }
        return false;
    }
}
