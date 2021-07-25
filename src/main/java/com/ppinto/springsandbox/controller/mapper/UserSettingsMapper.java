package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.controller.dto.UserSettingsDto;
import com.ppinto.springsandbox.controller.dto.UserSettingsUpdateDto;
import com.ppinto.springsandbox.model.UserSettings;
import com.ppinto.springsandbox.patch.Patch;
import com.ppinto.springsandbox.patch.UserSettingsPatch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mapper(componentModel = "spring", uses = PatchMapper.class)
public interface UserSettingsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserSettings toUserSettings(UserSettingsDto settingsDto);

    UserSettingsPatch toPatch(UserSettingsUpdateDto updateDto);

    default Patch<UserSettings> toPatch(Optional<UserSettingsUpdateDto> updateDto) {
        return MappingHelper.convertToPatch(updateDto, this::toPatch);
    }
}
