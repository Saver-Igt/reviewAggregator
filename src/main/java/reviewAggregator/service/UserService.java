package reviewAggregator.service;

import reviewAggregator.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers() throws Exception;
    User getUser(int id) throws Exception;
    User addUser(User user) throws Exception;
    User editUser(int id, String login,String password) throws Exception;
    void deleteUser(int id) throws Exception;
}
