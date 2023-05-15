package dev.siraev.rest;

import com.fasterxml.jackson.annotation.JsonView;
import dev.siraev.models.*;
import dev.siraev.models.user.Role;
import dev.siraev.models.user.Status;
import dev.siraev.models.user.User;
import dev.siraev.repository.UserRepository;
import dev.siraev.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthRestController(AuthenticationManager authenticationManager,
                              UserRepository userRepository,
                              JwtTokenProvider jwtTokenProvider,
                              PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationRequestDTO request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            User user = userRepository.findByUsername(request.getUsername());
            if (user == null){
                return new ResponseEntity<>("Invalid username/password combination", HttpStatus.FORBIDDEN);
            }
            String token = jwtTokenProvider.createToken(request.getUsername(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("userRole", user.getRole().name());
            response.put("username", request.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch(AuthenticationException e){
            e.printStackTrace();
            return new ResponseEntity<>("Invalid username/password combination", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody User user){
        User findUserFromDb = userRepository.findByUsername(user.getUsername());
        if (findUserFromDb != null){
            return new ResponseEntity<>("This username is already taken. Try another username", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }
    @PostMapping("/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
    @GetMapping("/users")
    @JsonView(Views.UserView.class)
    public List<User> getUsers() throws Exception{
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    @JsonView(Views.UserView.class)
    public User getUser(@PathVariable Long id) throws Exception{
        return userRepository.findById(id).orElse(new User());
    }
}
