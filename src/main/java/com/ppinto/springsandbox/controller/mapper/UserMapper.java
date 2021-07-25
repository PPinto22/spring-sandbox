package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.controller.dto.UserCreateDto;
import com.ppinto.springsandbox.controller.dto.UserDto;
import com.ppinto.springsandbox.controller.dto.UserUpdateDto;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.patch.UserPatch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, PatchMapper.class, UserSettingsMapper.class})
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDtoList(Collection<User> users);

    @Mapping(target = "id", ignore = true)
    User toUser(UserCreateDto userCreateDto);

    UserPatch toPatch(UserUpdateDto userUpdateDto);
}
