package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.helpTables.User;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User getUser(long id) {
       return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
