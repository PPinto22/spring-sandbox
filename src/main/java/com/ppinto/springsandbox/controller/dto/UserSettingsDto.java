package com.ppinto.springsandbox.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsDto {
    private String setting1;
    private Integer setting2;
    private int setting3;
    private boolean setting4;
}
