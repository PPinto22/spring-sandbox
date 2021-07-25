package com.ppinto.springsandbox.fixtures;

import com.ppinto.springsandbox.controller.dto.UserSettingsUpdateDto;

import java.util.Optional;

public class UserSettingsUpdateDtoBuilders {

    public static UserSettingsUpdateDto.UserSettingsUpdateDtoBuilder fullUpdate() {
        return UserSettingsUpdateDto.builder()
                .setting1(Optional.of("Setting 1"))
                .setting2(Optional.of(2))
                .setting3(Optional.of(3))
                .setting4(Optional.of(true));
    }
}
