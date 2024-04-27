package com.dsi.user.service.services;

import com.dsi.user.service.models.User;
import com.dsi.user.service.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(
                () -> new Exception("Resoource Not Found for ID: "+userId)
        );
    }
}