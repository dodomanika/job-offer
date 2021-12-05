package com.example.joboffer.sharedkernell;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
//TODO: Add tests
public class UserName {
    private String name;

    public UserName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("User name: " + name + " is empty or blank");
        }
        this.name = name;
    }

    /*For JPA only*/
    protected UserName() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserName userName = (UserName) o;

        return name.equals(userName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
