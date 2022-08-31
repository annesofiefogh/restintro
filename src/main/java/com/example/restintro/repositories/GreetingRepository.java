package com.example.restintro.repositories;

import com.example.restintro.models.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
