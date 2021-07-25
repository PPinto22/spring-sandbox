package com.ppinto.springsandbox.controller.dto;

import com.ppinto.springsandbox.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotBlank
    @NotNull
    private String name;
    private List<UserRole> roles;
    private List<AddressDto> addresses;
    private UserSettingsDto settings;
}
