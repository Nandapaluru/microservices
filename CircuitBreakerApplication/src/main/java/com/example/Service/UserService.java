package com.example.Service;


import com.example.Entity.User;
import com.example.Repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackGetUserById")
    public User getUserById(Long id) {
        // Simulate failure for testing circuit breaker
        if (id > 5) {
            throw new RuntimeException("Simulated Server Failure");
        }
        return userRepository.findAllById(id).orElse(null);
    }

    public User fallbackGetUserById(Long id, Throwable t) {
        return new User("Fallback User", "fallback@example.com");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.saveAll(user);
    }
}

