package com.example.restintro.services;

import com.example.restintro.models.User;
import com.example.restintro.repositories.IUser;
import com.example.restintro.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUser {

    private UserRepository userRepo;

    public UserService (UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
        userRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public User save(User object) {
        return userRepo.save(object);
    }

    @Override
    public void delete(User object) {
        userRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

}
