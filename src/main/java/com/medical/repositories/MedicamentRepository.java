package com.medical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
