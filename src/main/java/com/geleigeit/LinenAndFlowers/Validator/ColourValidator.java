package com.geleigeit.LinenAndFlowers.Validator;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ColourValidator extends AbstractValidator<Colour> {

    private final ColourRepository colourRepository;

    @Autowired
    public ColourValidator(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Colour.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Colour colour = (Colour) object;
//        ValidationUtils.rejectIfEmpty(errors, "colour", "ColourName.isNull");
        if (colour.getColour() == null) {
            errors.rejectValue("colour", "ColourName.isNull");
        } else if (colour.getColour().trim().length() < 3) {
            errors.rejectValue("colour", "ColourName.lessThanThree");
        } else if (colourRepository.findByColour(colour.getColour()) != null) {
            errors.rejectValue("colour", "Colour.alreadyExist");
        }
    }
}