package com.medical.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.entities.Medicament;
import com.medical.repositories.MaladieRepository;
import com.medical.repositories.MedicamentRepository;
import com.medical.services.MedicamentService;

@Service
public class MedicamentServiceImplement implements MedicamentService {

	@Autowired
	MaladieRepository maladieRepository;
	@Autowired
MedicamentRepository medicamentRepository;
	
	@Override
	public List<Medicament> getAllMedicaments() {
		// TODO Auto-generated method stub
		return medicamentRepository.findAll();
	}

	@Override
	public Medicament addOneMedicament(Medicament medicament, long idMaladie) {
		// TODO Auto-generated method stub
		medicament.setMaladie(maladieRepository.findById(idMaladie).orElse(null)); 
		return medicamentRepository.save(medicament);
	}

	@Override
	public Optional<Medicament> getOneMedicament(long id) {
		// TODO Auto-generated method stub
		return medicamentRepository.findById(id);
	}

	@Override
	public void deleteOneMedicament(long id) {
		// TODO Auto-generated method stub
		medicamentRepository.deleteById(id);

	}

}
