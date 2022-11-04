package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceCollection implements UserService{
    private List<User> users = new ArrayList<>();
    public UserServiceCollection() {
        users.add(new User(1,"user", "user"));
        users.add(new User(2,"admin", "admin"));
        users.add(new User(3,"login", "123"));
    }
    @Override
    public List<User> getUsers() throws Exception {
        return users;
    }

    @Override
    public User getUser(int id) throws Exception {
        return users.stream().filter(user -> user.getId() == id).findFirst()
                .orElse(new User());
    }

    @Override
    public User addUser(User user) throws Exception {
        users.add(user);
        return user;
    }

    @Override
    public User editUser(int id, String login, String password) throws Exception {
        return users.stream().filter(user -> user.getId() == id).findFirst()
                .map(user -> {
                    user.setLogin(login);
                    user.setPassword(password);
                    return user;
                }).orElse(new User());
    }

    @Override
    public void deleteUser(int id) throws Exception {
        users = users.stream().filter(user -> user.getId() != id)
                .collect(Collectors.toList());
    }
}
