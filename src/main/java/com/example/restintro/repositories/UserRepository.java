package com.example.restintro.repositories;

import com.example.restintro.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
