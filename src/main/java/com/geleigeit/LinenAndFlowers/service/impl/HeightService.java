package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.repository.HeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeightService {

    private final HeightRepository heightRepository;

    @Autowired
    public HeightService(HeightRepository heightRepository) {
        this.heightRepository = heightRepository;
    }
}
