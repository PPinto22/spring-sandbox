package com.ppinto.springsandbox.service;

import com.ppinto.springsandbox.fixtures.UserBuilders;
import com.ppinto.springsandbox.fixtures.UserPatchBuilders;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.model.UserRole;
import com.ppinto.springsandbox.patch.ReplaceOp;
import com.ppinto.springsandbox.patch.UserPatch;
import com.ppinto.springsandbox.repository.UserRepository;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        reset(userRepository);
        given(userRepository.save(any())).willAnswer(invocation -> invocation.getArgument(0));
    }

    @SneakyThrows
    @Test
    public void givenFullReplaceUserPatch_whenUpdate_thenUpdateUser() {
        // Given
        final User existingUser = UserBuilders.admin().build();
        final UserPatch userPatch = UserPatchBuilders.fullUpdate().build();
        given(userRepository.findById(any())).willReturn(Optional.of(existingUser));
        // When
        final User updatedUser = userService.update(0L, userPatch);
        // Then
        Assertions.assertThat(updatedUser.getName()).isEqualTo("New Name");
        Assertions.assertThat(updatedUser.getRoles()).containsExactly(UserRole.USER);
        Assertions.assertThat(updatedUser.getAddresses()).isEqualTo(((ReplaceOp) userPatch.getAddresses()).getNewValue());
        Assertions.assertThat(updatedUser.getSettings().getSetting1()).isEqualTo("New Setting1");
        Assertions.assertThat(updatedUser.getSettings().getSetting2()).isEqualTo(2);
        Assertions.assertThat(updatedUser.getSettings().getSetting3()).isEqualTo(3);
        Assertions.assertThat(updatedUser.getSettings().isSetting4()).isEqualTo(true);
    }

    @SneakyThrows
    @Test
    public void givenEmptyUserPatch_whenUpdate_thenDoNothing() {
        // Given
        final User existingUser = UserBuilders.admin().build();
        final UserPatch userPatch = new UserPatch();
        given(userRepository.findById(any())).willReturn(Optional.of(existingUser));
        // When
        final User updatedUser = userService.update(0L, userPatch);
        // Then
        Assertions.assertThat(updatedUser).usingRecursiveComparison().isEqualTo(existingUser);
    }
}
