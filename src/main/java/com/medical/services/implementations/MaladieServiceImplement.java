package com.medical.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.entities.Maladie;
import com.medical.repositories.MaladieRepository;
import com.medical.repositories.UserRepository;
import com.medical.services.MaladieService;

import jakarta.persistence.EntityNotFoundException;
@Service
public class MaladieServiceImplement implements MaladieService {
	@Autowired
	MaladieRepository maladieRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Maladie> getAllMaladies() {
		// TODO Auto-generated method stub
		return maladieRepository.findAll();
	}

	@Override
	public Maladie addOneMaladie(Maladie Maladie, long idUser) {
		// TODO Auto-generated method stub
		Maladie.setUser(userRepository.findById(idUser).orElseThrow(()->new EntityNotFoundException("user not found")));
		return maladieRepository.save(Maladie);
	}

	@Override
	public Optional<Maladie> getOneMaladie(long id) {
		// TODO Auto-generated method stub
		return maladieRepository.findById(id);
	}

	@Override
	public void deleteOneMaladie(long id) {
		// TODO Auto-generated method stub
		maladieRepository.deleteById(id);

	}

}
