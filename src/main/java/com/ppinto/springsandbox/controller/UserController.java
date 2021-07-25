package com.ppinto.springsandbox.controller;

import com.ppinto.springsandbox.controller.dto.UserCreateDto;
import com.ppinto.springsandbox.controller.dto.UserDto;
import com.ppinto.springsandbox.controller.dto.UserUpdateDto;
import com.ppinto.springsandbox.controller.mapper.UserMapper;
import com.ppinto.springsandbox.exception.UserNotFoundException;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.patch.UserPatch;
import com.ppinto.springsandbox.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        final List<User> users = userService.findAll();
        return ResponseEntity.ok(userMapper.toDtoList(users));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserCreateDto userCreateDto) {
        final User givenUser = userMapper.toUser(userCreateDto);
        final User createdUser = userService.create(givenUser);
        return ResponseEntity.ok(userMapper.toDto(createdUser));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> get(@PathVariable Long userId) throws UserNotFoundException {
        final User user = userService.findById(userId);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable Long userId,
                                          @RequestBody @Valid UserUpdateDto updateUserDto)
            throws UserNotFoundException {

        final UserPatch userPatch = userMapper.toPatch(updateUserDto);
        final User updatedUser = userService.update(userId, userPatch);
        return ResponseEntity.ok(userMapper.toDto(updatedUser));
    }

}
