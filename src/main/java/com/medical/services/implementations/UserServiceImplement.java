package com.medical.services.implementations;

import java.util.List;
import java.util.Optional;

import com.medical.entities.Profile;
import com.medical.entities.User;
import com.medical.services.UserService;

public class UserServiceImplement implements UserService {

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getOneUser(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User addOneUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteOneUser(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User AssignProfileToUser(Long userId, Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfile(Profile profile, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
