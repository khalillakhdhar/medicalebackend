package com.medical.services;

import java.util.List;
import java.util.Optional;

import com.medical.entities.Rappel;

public interface RappelService {
	public List<Rappel> getAllRappels();
	public Rappel addOneRappel(Rappel rappel,long idMedicament);
	public Optional<Rappel> getOneRappel(long id);
	public void deleteOneRappel(long id);
	

}
