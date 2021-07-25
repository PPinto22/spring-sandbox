package com.ppinto.springsandbox.repository;

import com.ppinto.springsandbox.fixtures.UserBuilders;
import com.ppinto.springsandbox.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        final User user = UserBuilders.admin().build();
        final User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isNotNull();
    }

}
