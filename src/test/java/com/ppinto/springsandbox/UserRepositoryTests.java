package com.ppinto.springsandbox;

import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.EnumSet;

import static com.ppinto.springsandbox.model.UserRole.ADMIN;
import static com.ppinto.springsandbox.model.UserRole.USER;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        final User user = User.builder()
                .name("John Doe")
                .roles(EnumSet.of(USER, ADMIN))
                .build();

        final User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
        assertThat(user.getId()).isNotNull();
    }
}
