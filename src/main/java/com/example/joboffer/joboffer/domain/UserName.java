package com.example.joboffer.joboffer.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
//TODO: Validate input
//TODO: Add tests
public class UserName {
    private String name;

    public UserName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("User name: " + name + " is too short");
        }
        this.name = name;
    }

    /*For JPA only*/
    protected UserName() {
    }
}
