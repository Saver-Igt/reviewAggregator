package dev.siraev.rest;

import com.fasterxml.jackson.annotation.JsonView;
import dev.siraev.models.AuthenticationRequestDTO;
import dev.siraev.models.User;
import dev.siraev.models.Views;
import dev.siraev.repository.UserRepository;
import dev.siraev.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    public AuthRestController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationRequestDTO request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
            String token = jwtTokenProvider.createToken(request.getUsername(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("userId", user.getId());
            response.put("username", request.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch(AuthenticationException e){
            e.printStackTrace();
            return new ResponseEntity<>("Invalid username/password combination", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
    @GetMapping("/users")
    @JsonView(Views.UserView.class)
    public @ResponseBody List<User> getUsers() throws Exception{
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    @JsonView(Views.UserView.class)
    public @ResponseBody User getUser(@PathVariable Long id) throws Exception{
        return userRepository.findById(id).orElse(new User());
    }
}
