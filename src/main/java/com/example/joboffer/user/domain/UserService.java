package com.example.joboffer.user.domain;

import com.example.joboffer.user.application.UserRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {
        LocalDate creationDate = LocalDate.now();
        User user = userRequest.toEntity(creationDate);

        userRepository.save(user);
    }
}
