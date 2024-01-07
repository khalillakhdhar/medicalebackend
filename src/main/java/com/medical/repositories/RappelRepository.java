package com.medical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Rappel;

public interface RappelRepository extends JpaRepository<Rappel, Long> {

}
