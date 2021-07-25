package com.ppinto.springsandbox.controller.dto;

import com.ppinto.springsandbox.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private List<UserRole> roles;
    private List<AddressDto> addresses;
    private UserSettingsDto settings;
}
