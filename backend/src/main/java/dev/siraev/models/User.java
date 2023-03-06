package dev.siraev.models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.IdName.class)
    private Long id;
    @Column(name = "username")
    @JsonView(Views.IdName.class)
    private String username;
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
