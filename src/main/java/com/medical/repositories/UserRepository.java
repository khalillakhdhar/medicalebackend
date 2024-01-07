package com.medical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
