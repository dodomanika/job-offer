package com.example.joboffer.user.application;

import com.example.joboffer.sharedkernell.UserName;
import com.example.joboffer.user.domain.User;

import java.io.Serializable;
import java.time.LocalDate;

public class UserRequest implements Serializable {
    private final String login;
    private final String password;
    private final UserName name;

    public UserRequest(String login, String password, UserName name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User toEntity(LocalDate date) {
        return new User(login, password, name, date);
    }
}
