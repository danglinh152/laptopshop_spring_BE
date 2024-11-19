package com.twohdcd.Laptopshop.controller;


import com.twohdcd.Laptopshop.domain.Product;
import com.twohdcd.Laptopshop.domain.User;
import com.twohdcd.Laptopshop.service.ProductService;
import com.twohdcd.Laptopshop.service.UserService;
import com.twohdcd.Laptopshop.util.constant.GenderEnum;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User userParam, @PathVariable int id) {
        User user = userService.getUserById(id);
        user.setFirstName(userParam.getFirstName());
        user.setLastName(userParam.getLastName());
        user.setEmail(userParam.getEmail());
        user.setPassword(userParam.getPassword());
        user.setAge(userParam.getAge());
        user.setGender(userParam.getGender());
        user.setAddress(userParam.getAddress());
        user.setPhone(userParam.getPhone());
        user.setRefreshToken(userParam.getRefreshToken());
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
