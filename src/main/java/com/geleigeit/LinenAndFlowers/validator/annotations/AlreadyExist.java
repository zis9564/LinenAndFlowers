package com.geleigeit.LinenAndFlowers.validator.annotations;

import com.geleigeit.LinenAndFlowers.validator.annotationProvider.AlreadyExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= AlreadyExistValidator.class)
public @interface AlreadyExist {
//        String message() default "{colour.colourName.alreadyExist}";
//        Class<?>[] groups() default {};
//        Class<? extends Payload>[] payload() default {};
}
