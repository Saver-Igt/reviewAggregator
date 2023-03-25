package dev.siraev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
