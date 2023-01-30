package dev.siraev.controllers;

import dev.siraev.repository.UserRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    private UserRepository userRepository;
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
