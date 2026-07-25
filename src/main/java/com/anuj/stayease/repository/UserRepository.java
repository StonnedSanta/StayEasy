package com.anuj.stayease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.stayease.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
