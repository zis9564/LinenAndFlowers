package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.config.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.entity.Role;
import com.geleigeit.LinenAndFlowers.entity.User;
import com.geleigeit.LinenAndFlowers.repository.RoleRepository;
import com.geleigeit.LinenAndFlowers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService( UserRepository userRepository,
                        RoleRepository roleRepository,
                        PasswordEncoder passwordEncoder) {
        super(userRepository);
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addOne(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.findById(user.getId()).orElseThrow(NotFoundException::new));
//        user.setRoles(roles);
        user.setRoles(user.getRoles());
        repository.save(user);
    }

    public User findByUserName(String username) {
        return repository.findByUserName(username);
    }
}
