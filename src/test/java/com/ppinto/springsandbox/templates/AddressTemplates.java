package com.ppinto.springsandbox.templates;

import com.ppinto.springsandbox.model.Address;

public class AddressTemplates {

    public static Address.AddressBuilder newYork() {
        return Address.builder()
                .country("United States")
                .state("New York")
                .city("New York")
                .postalCode("10005")
                .line1("3375 Forest Avenue");
    }
}
