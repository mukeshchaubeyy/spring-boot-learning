package com.example.employeeService.repository;

import com.example.employeeService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String userName);
}
