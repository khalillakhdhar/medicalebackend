package com.medical.services;

import java.util.List;
import java.util.Optional;


import com.medical.entities.Profile;
import com.medical.entities.User;

public interface UserService {
public List<User> getUsers();
public Optional<User> getOneUser(long id);
public User addOneUser(User user);
public void DeleteOneUser(long id);
public User AssignProfileToUser(Long userId,Profile profile);
public Profile updateProfile(Profile profile,long userId );

}
