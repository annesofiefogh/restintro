package com.example.restintro.controllers;

import com.example.restintro.models.User;
import com.example.restintro.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<Set<User>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<Set<User>> addUser(User name){
        System.out.println("Added user: " + name.getName());
        userService.save(name);
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Set<User>> deleteUser(User name){
        System.out.println("Deleted user: " + name.getName());
        userService.delete(name);
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    /*@PutMapping("/editUser")
    public ResponseEntity<Set<User>> editUser(Long id, User name){
        Optional<User> updated = userService.findById(id);
    }*/

}
