package com.ppinto.springsandbox.controller.dto;

import com.ppinto.springsandbox.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private Optional<String> name;
    private Optional<Set<UserRole>> roles;
    private Optional<List<AddressDto>> addresses;
    private Optional<UserSettingsUpdateDto> settings;
}
