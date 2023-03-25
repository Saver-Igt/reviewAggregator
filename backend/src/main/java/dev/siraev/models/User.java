package dev.siraev.models;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.*;
@Entity
@Table(name = "usr")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserView.class)
    private Long id;
    @Column(name = "username")
    @JsonView(Views.UserView.class)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    @JsonView(Views.UserView.class)
    private String firstName;
    @Column(name = "last_name")
    @JsonView(Views.UserView.class)
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Column(name = "age")
    @JsonView(Views.UserView.class)
    private int age;
    @Enumerated(value = EnumType.STRING)
    @JsonView(Views.UserView.class)
    @Column(name = "gender")
    private Gender gender;
    public User() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
