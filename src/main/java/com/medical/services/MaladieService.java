package com.medical.services;

import java.util.List;
import java.util.Optional;

import com.medical.entities.Maladie;

public interface MaladieService {
	public List<Maladie> getAllMaladies();
	public Maladie addOneMaladie(Maladie Maladie,long idUser);
	public Optional<Maladie> getOneMaladie(long id);
	public void deleteOneMaladie(long id);
}
