package reviewAggregator.service;

import org.springframework.stereotype.Service;
import reviewAggregator.models.User;
import reviewAggregator.models.UserList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
@Service

public class UserServiceXML implements UserService{
    //private static final String userPath = "E:\\Prog\\Java\\ReviewAggregator\\src\\main\\resources\\user.xml";
    private static final String userPath = UserServiceXML.class.getClassLoader().getResource("user.xml").getPath();
    @Override
    public List<User> getUsers() throws Exception {
        return getUserList().getUsers();
    }

    @Override
    public User getUser(int id) throws Exception {
        return getUsers().stream().filter(user -> user.getId() == id)
                .findFirst().orElse(new User());
    }

    @Override
    public User addUser(User user) throws Exception {
        UserList userList = getUserList();
        userList.getUsers().add(user);
        save(userList);
        return user;
    }

    @Override
    public User editUser(int id, String login, String password) throws Exception {
        UserList userList = getUserList();
        User findUser = userList.getUsers().stream().filter(user -> user.getId() == id)
                .findFirst().orElse(null);
        if(findUser == null){
            return null;
        }
        findUser.setLogin(login);
        findUser.setPassword(password);
        save(userList);
        return findUser;
    }

    @Override
    public void deleteUser(int id) throws Exception {
        UserList userList = getUserList();
        User findUser = userList.getUsers().stream().filter(user -> user.getId() == id)
                .findFirst().orElse(null);
        if(findUser != null){
            userList.getUsers().remove(findUser);
            save(userList);
        }
    }
    private UserList getUserList() throws Exception{
        File file = new File(userPath);
        JAXBContext context = JAXBContext.newInstance(UserList.class);
        Unmarshaller unMarshaller = context.createUnmarshaller();
        return (UserList) unMarshaller.unmarshal(file);
    }
    private void save(UserList studentList)throws Exception{
        File file = new File(userPath);
        JAXBContext context = JAXBContext.newInstance(UserList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(studentList, file);
    }
}
