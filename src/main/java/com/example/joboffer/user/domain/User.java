package com.example.joboffer.user.domain;

import com.example.joboffer.sharedkernell.UserName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;
    private UserName name;
    private LocalDate creationDate;

    public User(String login, String password, UserName name, LocalDate creationDate) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.creationDate = creationDate;
    }

    /*For JPA only*/
    protected User() {

    }
}
