package com.splitnest.controller;

import com.splitnest.entities.User;
import com.splitnest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value="/add")
    public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName){
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        userRepository.save(newUser);
        logger.info("New user added");
    }

    @GetMapping(value="/get")
    public void getUsers() {
        for (User user : userRepository.findAll()) {
            logger.info("Found user:" + user.getUsername());
        }
    }
}

