package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Size;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Transactional
    public Size getOne(long id){
        return sizeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
