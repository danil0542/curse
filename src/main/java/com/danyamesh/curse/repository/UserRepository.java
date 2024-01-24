package com.danyamesh.curse.repository;

import com.danyamesh.curse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
