package com.ppinto.springsandbox.repository;

import com.ppinto.springsandbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
