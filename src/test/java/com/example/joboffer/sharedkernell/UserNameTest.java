package com.example.joboffer.sharedkernell;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNameTest {

    @Test
    void shouldCreateUserNameWhenNameGiven() {
        String name = "COMP2any!";

        UserName userName = new UserName(name);

        assertThat(userName).isNotNull();
        assertThat(userName.getName()).isEqualTo("COMP2any!");
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserNameWithNoNameGiven() {
        String name = null;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserName(name);
        }).withMessage("User name: " + null + " is empty or blank");
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserNameWithEmptyNameGiven() {
        String name = "";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserName(name);
        }).withMessage("User name:  is empty or blank");
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserNameWithBlankNameGiven() {
        String name = "\n";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserName(name);
        }).withMessage("User name: " + "\n" + " is empty or blank");
    }
}