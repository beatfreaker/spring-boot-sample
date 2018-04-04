package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.entities.UserEntity;
import com.example.demo.services.interfaces.IGetUserService;
import com.example.demo.repositories.*;


import javax.inject.Inject;

public class GetUserService implements IGetUserService {

	@Inject
	UserRepository userRepository;

	@Override
	public List<UserEntity> getUser(String email) {
		List<UserEntity> user = null;
		user = userRepository.findByEmail(email);
		return user;
	}

}
