package com.ppinto.springsandbox.fixtures;

import com.ppinto.springsandbox.controller.dto.AddressDto;
import com.ppinto.springsandbox.controller.dto.UserUpdateDto;
import com.ppinto.springsandbox.model.UserRole;
import org.jeasy.random.EasyRandom;

import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUpdateDtoBuilders {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static UserUpdateDto.UserUpdateDtoBuilder fullUpdate() {
        return UserUpdateDto.builder()
                .name(Optional.of("New Name"))
                .addresses(Optional.of(easyRandom.objects(AddressDto.class, 3).collect(Collectors.toList())))
                .roles(Optional.of(EnumSet.of(UserRole.USER)))
                .settings(Optional.of(UserSettingsUpdateDtoBuilders.fullUpdate().build()));
    }
}
