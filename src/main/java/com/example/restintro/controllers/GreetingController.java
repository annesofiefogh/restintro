package com.example.restintro.controllers;

import com.example.restintro.models.Greeting;
import com.example.restintro.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController //returns JSON instead of entire webpage (using @Controller)
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/greetings")
    public ResponseEntity<Set<Greeting>> getGreeting(){ //returns data as JSON
        greetingService.save(new Greeting());
        return new ResponseEntity<>(greetingService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addGreeting")
    public ResponseEntity<Set<Greeting>> addGreeting(Greeting greeting){ // returns data as JSON
        System.out.println("Received addGreeting " + greeting.getMessage());
        greetingService.save(greeting);
        return new ResponseEntity<>(greetingService.findAll(), HttpStatus.OK);
    }

}
