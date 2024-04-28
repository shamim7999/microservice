package com.dsi.user.service.controllers;

import com.dsi.user.service.models.User;
import com.dsi.user.service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ofNullable(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) throws Exception {
        return ResponseEntity.ofNullable(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ofNullable(userService.getAllUser());
    }


}
