package com.ppinto.springsandbox.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsUpdateDto {
    private Optional<String> setting1;
    private Optional<Integer> setting2;
    private Optional<Integer> setting3;
    private Optional<Boolean> setting4;
}
