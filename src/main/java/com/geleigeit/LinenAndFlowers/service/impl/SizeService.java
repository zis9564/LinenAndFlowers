package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Size;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.SizeRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SizeService extends AbstractService<Size, SizeRepository> {

    @Autowired
    public SizeService(SizeRepository repository) {
        super(repository);
    }

    @Transactional
    public Size getOne(long id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
