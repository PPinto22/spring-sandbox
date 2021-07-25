package com.ppinto.springsandbox.service;

import com.ppinto.springsandbox.exception.UserNotFoundException;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.patch.UserPatch;
import com.ppinto.springsandbox.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User create(User user) {
        assert user.getId() == null;
        return userRepository.save(user);
    }

    public User update(Long id, UserPatch patch) throws UserNotFoundException {
        final User existingUser = findById(id);
        final User patchedUser = existingUser.toBuilder()
                .name(patch.getName().apply(existingUser.getName()))
                .roles(patch.getRoles().apply(existingUser.getRoles()))
                .addresses(patch.getAddresses().apply(existingUser.getAddresses()))
                .settings(patch.getSettings().apply(existingUser.getSettings()))
                .build();
        return userRepository.save(patchedUser);
    }
}
