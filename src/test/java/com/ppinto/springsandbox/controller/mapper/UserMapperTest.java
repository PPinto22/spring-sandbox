package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.controller.dto.UserUpdateDto;
import com.ppinto.springsandbox.fixtures.UserUpdateDtoBuilders;
import com.ppinto.springsandbox.patch.NoOp;
import com.ppinto.springsandbox.patch.ReplaceOp;
import com.ppinto.springsandbox.patch.UserPatch;
import com.ppinto.springsandbox.patch.UserSettingsPatch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void givenFullUserUpdateDto_whenMapToPatch_thenPatchOk() {
        // Given
        final UserUpdateDto userUpdateDto = UserUpdateDtoBuilders.fullUpdate().build();
        // When
        final UserPatch userPatch = userMapper.toPatch(userUpdateDto);
        // Then
        Assertions.assertThat(userPatch.getName()).isEqualTo(ReplaceOp.of(userUpdateDto.getName().get()));
        Assertions.assertThat(userPatch.getRoles()).isEqualTo(ReplaceOp.of(userUpdateDto.getRoles().get()));
        Assertions.assertThat(userPatch.getAddresses()).isInstanceOf(ReplaceOp.class);
        Assertions.assertThat(userPatch.getSettings()).isInstanceOf(UserSettingsPatch.class);
    }

    @Test
    void givenEmptyUserUpdateDto_whenMapToPatch_thenNoOpsPatch() {
        // Given
        final UserUpdateDto userUpdateDto = new UserUpdateDto();
        // When
        final UserPatch userPatch = userMapper.toPatch(userUpdateDto);
        // Then
        Assertions.assertThat(userPatch.getName()).isInstanceOf(NoOp.class);
        Assertions.assertThat(userPatch.getRoles()).isInstanceOf(NoOp.class);
        Assertions.assertThat(userPatch.getAddresses()).isInstanceOf(NoOp.class);
        Assertions.assertThat(userPatch.getSettings()).isInstanceOf(NoOp.class);
    }

}
