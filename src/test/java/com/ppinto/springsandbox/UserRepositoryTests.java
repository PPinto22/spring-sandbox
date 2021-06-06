package com.ppinto.springsandbox;

import com.ppinto.springsandbox.model.Address;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.repository.UserRepository;
import com.ppinto.springsandbox.templates.AddressTemplates;
import com.ppinto.springsandbox.templates.UserTemplates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        final User user = UserTemplates.admin().build();
        final User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isNotNull();
    }

    @Test
    void shouldPreserveOrderOfAddresses() {
        final List<Address> addresses = List.of(
                AddressTemplates.newYork().line2("Address 0").build(),
                AddressTemplates.newYork().line2("Address 1").build(),
                AddressTemplates.newYork().line2("Address 2").build(),
                AddressTemplates.newYork().line2("Address 3").build()
        );
        final User user = UserTemplates.admin()
                .clearAddresses()
                .addresses(addresses)
                .build();

        userRepository.save(user);
        final User fetchedUser = userRepository.findById(user.getId()).orElseThrow();

        // FIXME(PP) The order is not being tested properly - this passes even without @OrderColumn
        assertThat(fetchedUser.getAddresses()).containsExactlyElementsOf(addresses);
    }
}
