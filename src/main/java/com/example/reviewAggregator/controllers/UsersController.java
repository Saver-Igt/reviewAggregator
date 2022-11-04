package com.example.reviewAggregator.controllers;

import com.example.reviewAggregator.models.User;
import com.example.reviewAggregator.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public @ResponseBody
    List<User> getUsers() throws Exception{
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    User getUser(@PathVariable int id) throws Exception{
        return userService.getUser(id);
    }
    @PostMapping
    public @ResponseBody
    User addUser(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }
    @PutMapping("/{id}")
    public@ResponseBody
    User editUser(@PathVariable int id, @RequestBody String login, @RequestBody String password) throws Exception{
        return userService.editUser(id, login, password);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id)throws Exception{
        userService.deleteUser(id);
    }
}
