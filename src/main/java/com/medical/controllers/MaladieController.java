package com.medical.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entities.Maladie;
import com.medical.services.MaladieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/maladie")
public class MaladieController {
	
	@Autowired
	MaladieService maladieService;
	@GetMapping
	public ResponseEntity<List<Maladie>> getAllMaladies()
	{
	return ResponseEntity.ok(maladieService.getAllMaladies());	
	}
	@PostMapping
	public ResponseEntity<Maladie> addOneMaladie(@Valid @RequestBody Maladie maladie,@RequestParam(required = true) long userid)
	{
		return ResponseEntity.ok(maladieService.addOneMaladie(maladie, userid));		
		
	}
	@DeleteMapping("/{id}")
	public void deleteMaladie(@PathVariable long id)
	{
		maladieService.deleteOneMaladie(id);
	}
	
	

}
