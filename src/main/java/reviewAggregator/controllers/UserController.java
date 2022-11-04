package reviewAggregator.controllers;

import reviewAggregator.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reviewAggregator.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
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

    @GetMapping("/bye")
    public String byepage(){
        return "first_bye";
    }
}
