package com.medical.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entities.Profile;
import com.medical.entities.User;
import com.medical.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getUsers());
	}
	@PostMapping
	public ResponseEntity<User> addOne(@Valid @RequestBody User user)
	{
		return ResponseEntity.ok(userService.addOneUser(user));
	}
	@PutMapping("/{userId}")
	public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile,@PathVariable long userId )
	{
		return ResponseEntity.ok(userService.updateProfile(profile, userId));
	}
	@PatchMapping("/{userId}")
	public ResponseEntity<User> assignProfile(@RequestBody Profile profile,@PathVariable long userId)
	{
		return ResponseEntity.ok(userService.AssignProfileToUser(userId, profile));
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id)
	{
		userService.DeleteOneUser(id);	}
}
