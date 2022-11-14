package com.matrimony.controller;

import com.matrimony.repository.UserRepository;
import com.matrimony.model.User;
import com.matrimony.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user/v1/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MyUserDetailsService userDetailsService;

    @GetMapping("/details")
    public ResponseEntity<Optional<User>> getUserByUserId(@RequestParam String id) throws Exception {
        return ResponseEntity.ok(userDetailsService.getUserById(id));
    }

    @GetMapping(value = "/list-users")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
