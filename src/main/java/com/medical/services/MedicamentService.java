package com.medical.services;

import java.util.List;
import java.util.Optional;

import com.medical.entities.Medicament;

public interface MedicamentService {
	public List<Medicament> getAllMedicaments();
	public Medicament addOneMedicament(Medicament Medicament,long idMaladie);
	public Optional<Medicament> getOneMedicament(long id);
	public void deleteOneMedicament(long id);
}
