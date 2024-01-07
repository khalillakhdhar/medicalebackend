package com.medical.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medical.entities.Rappel;
import com.medical.repositories.MedicamentRepository;
import com.medical.repositories.RappelRepository;
import com.medical.services.RappelService;

@Service
public class RappelServiceImplement implements RappelService {
	private final RappelRepository rappelRepository;
	private final MedicamentRepository medicamentRepository;
	
	
	

	public RappelServiceImplement(RappelRepository rappelRepository, MedicamentRepository medicamentRepository) {
		super();
		this.rappelRepository = rappelRepository;
		this.medicamentRepository = medicamentRepository;
	}

	@Override
	public List<Rappel> getAllRappels() {
		// TODO Auto-generated method stub
		return rappelRepository.findAll();
	}

	@Override
	public Rappel addOneRappel(Rappel rappel, long idMedicament) {
		// TODO Auto-generated method stub
		rappel.setMedicament(medicamentRepository.findById(idMedicament).orElse(null));
		
		
		
		return rappelRepository.save(rappel);
	}

	@Override
	public Optional<Rappel> getOneRappel(long id) {
		// TODO Auto-generated method stub
		return rappelRepository.findById(id);
	}

	@Override
	public void deleteOneRappel(long id) {
		// TODO Auto-generated method stub
		rappelRepository.deleteById(id);

	}

}
