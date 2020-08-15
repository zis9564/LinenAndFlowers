package com.geleigeit.LinenAndFlowers.Validator;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractValidator<E extends AbstractEntity> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
    }
}
