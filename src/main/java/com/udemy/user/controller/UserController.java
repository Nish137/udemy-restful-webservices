package com.udemy.user.controller;

import com.udemy.user.model.User;
import com.udemy.user.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("jpa/user/{id}")
    public Optional<User> findUsers(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(User user) {
        return userRepository.findAll();
    }

    @DeleteMapping("delete/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User with ID " + id + " deleted successfully");

    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping("/users")
    public List<User> createUsers(@RequestBody List<User> user){
       return userRepository.saveAll(user);
    }
}
















