package com.ppinto.springsandbox.fixtures;

import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.model.UserRole;
import org.jeasy.random.EasyRandom;

import java.util.EnumSet;

public class UserBuilders {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static User.UserBuilder admin() {
        final User.UserBuilder userBuilder = easyRandom.nextObject(User.UserBuilder.class);
        userBuilder.roles(EnumSet.of(UserRole.USER, UserRole.ADMIN));
        return userBuilder;
    }
}
