package com.example.joboffer.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
//TODO: Validate input
//TODO: Add tests
public class UserName {
    private String name;

    public UserName(String name) {
        this.name = name;
    }

    /*For JPA only*/
    protected UserName() {
    }
}
