package com.example.restintro.services;

import com.example.restintro.models.Greeting;
import com.example.restintro.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class GreetingService implements IGreetingService {

    private GreetingRepository repo; //Hibernate makes the object based on the interface

    public GreetingService(GreetingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Set<Greeting> findAll() {
        Set<Greeting> set = new HashSet<>();
        repo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Greeting save(Greeting object) {
        return repo.save(object);
    }

    @Override
    public void delete(Greeting object) {
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public Optional<Greeting> findById(Long aLong) {
        return Optional.empty();
    }
}
