package com.example.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
