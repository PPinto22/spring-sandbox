package com.ppinto.springsandbox.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Address {

    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String line1;
    private String line2;
}
