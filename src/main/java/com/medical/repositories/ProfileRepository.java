package com.medical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
