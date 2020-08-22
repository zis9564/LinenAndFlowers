package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.entity.User;
import com.geleigeit.LinenAndFlowers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/developers")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("{/id}")
    public User getOne(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User post(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("{/id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
