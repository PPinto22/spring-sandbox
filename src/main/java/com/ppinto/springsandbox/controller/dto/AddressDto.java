package com.ppinto.springsandbox.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String line1;
    private String line2;
}
