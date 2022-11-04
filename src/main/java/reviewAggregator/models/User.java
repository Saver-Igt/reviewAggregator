package reviewAggregator.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "login")
    private String login;
    @XmlElement(name = "password")
    private String password;
    private String email;
    private String userName;

    public User(){}
    public User(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
