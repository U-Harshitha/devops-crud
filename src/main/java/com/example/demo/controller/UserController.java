package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // POST create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    // GET by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // PATCH/UPDATE user
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return repo.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return repo.save(user);
        }).orElse(null);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
        return "User deleted";
    }
}
