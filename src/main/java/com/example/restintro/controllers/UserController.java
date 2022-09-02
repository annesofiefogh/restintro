package com.example.restintro.controllers;

import com.example.restintro.models.User;
import com.example.restintro.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    /*@PostMapping("/addUser")
    public ResponseEntity<User> addUser(User name){
        System.out.println("Added user: " + name.getName()); //sout good to check if the method works
        return new ResponseEntity<>(userService.save(name), HttpStatus.OK);
    }*/

    @PostMapping("/addUser")
    public ResponseEntity<Set<User>> addUser(User user){
        System.out.println("Added user to list: " + user.getName());
        userService.save(user);
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Set<User>> deleteUser(User user){
        System.out.println("Deleted user: " + user.getId());
        userService.delete(user);
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editUser")
    public ResponseEntity<Set<User>> editUser(Long id, User user){
        Optional<User> updated = userService.findById(id);
        if(updated.isPresent()){
            userService.save(user);
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.NOT_FOUND);
        }
    }

}
