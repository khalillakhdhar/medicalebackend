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

import com.medical.entities.Rappel;
import com.medical.services.RappelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("rappel")
public class RappelController {
	private final RappelService rappelService;

	public RappelController(RappelService rappelService) {
		super();
		this.rappelService = rappelService;
	}
	@GetMapping
	public ResponseEntity<List<Rappel>> getRappels()
	{
		
	return ResponseEntity.ok(rappelService.getAllRappels());
	}
	@PostMapping
	public ResponseEntity<Rappel> addRappel(@RequestBody @Valid Rappel rappel,@RequestParam long maladieId)
	{
		return ResponseEntity.ok(rappelService.addOneRappel(rappel, maladieId));

	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id)
	{
		rappelService.deleteOneRappel(id);
		
	}
}
