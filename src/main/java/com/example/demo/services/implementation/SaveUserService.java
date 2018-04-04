package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.models.User;
import com.example.demo.services.interfaces.ISaveUserService;
import javax.inject.Inject;
import javax.inject.Provider;
import com.example.demo.repositories.*;
import com.example.demo.services.interfaces.*;

import com.example.demo.config.Utility;
import com.example.demo.entities.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.example.demo.config.*;
import java.lang.RuntimeException;

public class SaveUserService implements ISaveUserService {
	
	@Inject
	Provider<UserEntity> userEntityBeanProvider;
	
	@Inject
	UserRepository repository;
	
	@Inject
	IGetUserService getUserService;
	
	public Response saveUser(User userModel) {
		boolean isUserAlreadyExists = isUserAlreadyExists(userModel);
		if(!isUserAlreadyExists) {
			UserEntity user = userEntityBeanProvider.get();
			user.setFirstName(userModel.getFirstName());
			user.setLastName(userModel.getLastName());
			user.setEmail(userModel.getEmail());
			user.setPassword(Utility.getMD5(userModel.getPassword()));
			UserEntity savedEntity = repository.save(user);
			return Response.ok().build();
		} else {
			throw new RuntimeException("User with email provided already exists, Please choose different email address.");
			/*ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setMessage("User with email provided already exists, Please choose different email address.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
			.entity(errorMessage)
			.type(MediaType.APPLICATION_JSON)
			.build();*/
		}
	}
	
	public boolean isUserAlreadyExists(User user) {
		List<UserEntity> savedUser = getUserService.getUser(user.getEmail());
		return (savedUser != null && savedUser.size() > 0);
	}

}
