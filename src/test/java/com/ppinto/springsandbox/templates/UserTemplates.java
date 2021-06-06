package com.ppinto.springsandbox.templates;

import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.model.UserRole;

public class UserTemplates {

    public static User.UserBuilder admin() {
        return User.builder()
                .name("John Doe")
                .role(UserRole.USER)
                .role(UserRole.ADMIN)
                .address(AddressTemplates.newYork().build());
    }
}
