package com.medical.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entities.Medicament;
import com.medical.services.MedicamentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("medicament")
public class MedicamentController {
private final MedicamentService medicamentService;

public MedicamentController(MedicamentService medicamentService) {
	super();
	this.medicamentService = medicamentService;
}
@GetMapping
public ResponseEntity<List<Medicament>> getMedicaments()
{
	
return ResponseEntity.ok(medicamentService.getAllMedicaments());
}
@PostMapping
public ResponseEntity<Medicament> addMedicament(@RequestBody @Valid Medicament medicament,@RequestParam long maladieId)
{
	return ResponseEntity.ok(medicamentService.addOneMedicament(medicament, maladieId));

}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable long id)
{
	medicamentService.deleteOneMedicament(id);
	
}
	
}
