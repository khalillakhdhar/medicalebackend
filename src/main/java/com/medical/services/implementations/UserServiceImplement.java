package com.medical.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.entities.Profile;
import com.medical.entities.User;
import com.medical.repositories.ProfileRepository;
import com.medical.repositories.UserRepository;
import com.medical.services.UserService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class UserServiceImplement implements UserService {
private final UserRepository userRepository;
private final ProfileRepository profileRepository;

	public UserServiceImplement(UserRepository userRepository, ProfileRepository profileRepository) {
	super();
	this.userRepository = userRepository;
	this.profileRepository = profileRepository;
}

	@Override
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getOneUser(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User addOneUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void DeleteOneUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}

	@Override
	@Transactional
	public User AssignProfileToUser(Long userId, Profile profile) {
		// TODO Auto-generated method stub
		//profile.setId(userId);
		userRepository.findById(userId).map(user->{
			profile.setUser(user);
			user.setProfile(profile);
			return userRepository.save(user);
		}).orElseThrow(()-> new EntityNotFoundException("user notfound with id "+userId));
		return null;
	}

	@Override
	@Transactional
	public Profile updateProfile(Profile profile, long userId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(userId).map(userProfile->
		{
			userProfile=profile;
			userProfile.setId(userId);
			return profileRepository.save(userProfile);
		}).orElseThrow(()-> new EntityNotFoundException("user notfound with id "+userId));
	}

}
