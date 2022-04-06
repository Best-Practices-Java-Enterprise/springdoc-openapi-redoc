package com.bestpractices.springdoc.controller;

import com.bestpractices.springdoc.ServiceApi;
import com.bestpractices.springdoc.domain.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController implements ServiceApi {
    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public User getUser(String username) {
        return User.builder()
                .username("said@raiss")
                .firstname("SAID")
                .lastname("RAISS")
                .build();
    }

    @Override
    public User updateUser(User user) {
        return user;
    }

    @Override
    public Boolean deleteUser(String username) {
        return true;
    }

}
