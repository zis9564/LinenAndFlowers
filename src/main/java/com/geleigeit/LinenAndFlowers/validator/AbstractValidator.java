package com.geleigeit.LinenAndFlowers.validator;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractValidator<E extends BaseEntity> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
    }
}