package com.CPAN228.test1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // No encoding since we don't use Spring Security
        user.setEnabled(true);
        return user;
    }
}