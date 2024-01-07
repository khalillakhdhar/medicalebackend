package com.medical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Maladie;

public interface MaladieRepository extends JpaRepository<Maladie, Long> {

}
