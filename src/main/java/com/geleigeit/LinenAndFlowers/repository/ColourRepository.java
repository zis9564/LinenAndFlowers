package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends CommonRepository<Colour> {
    Colour findByColour(String colour) throws NotFoundException;
}