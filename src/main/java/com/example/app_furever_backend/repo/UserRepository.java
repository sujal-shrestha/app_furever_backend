package com.example.app_furever_backend.repo;

import com.example.app_furever_backend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // For finding by email only

    User findByEmailAndPassword(String email, String password);  // For finding by email and password
}
