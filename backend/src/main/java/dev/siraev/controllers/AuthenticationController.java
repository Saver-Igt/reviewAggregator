package dev.siraev.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.siraev.models.User;
import dev.siraev.models.Views;
import dev.siraev.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    /*
    private UserService userService;
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @JsonView(Views.IdName.class)
    public @ResponseBody String test(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return "Hello " + user.getUsername() + " nice job!";
    }
    @GetMapping
    @JsonView(Views.IdName.class)
    public @ResponseBody List<User> getUsers(){
        return userService.getUsers();
    }
     */
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
}
