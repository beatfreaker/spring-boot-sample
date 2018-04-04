package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.config.Utility;
import com.example.demo.entities.UserEntity;
import com.example.demo.models.User;
import com.example.demo.services.interfaces.IGetUserService;
import com.example.demo.services.interfaces.ILoginUserService;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import java.lang.RuntimeException;
import com.example.demo.entities.*;
import com.example.demo.models.*;

public class LoginUserService implements ILoginUserService {

	@Inject
	IGetUserService getUserService;
	
	@Inject
	User user;

	@Override
	public Response loginUser(User user) {
		List<UserEntity> userFromDB = getUserFromDB(user);
		boolean isUserDetailsMatchedWithExistingUser = isUserDetailsMatchedWithExistingUser(userFromDB);
		if(isUserDetailsMatchedWithExistingUser) {
			User usr =  getUserFromUserEntity(userFromDB.get(0));
			return Response.ok(usr).build();
		} else {
			throw new RuntimeException("Entered details doesnot match, Please make sure that you are entering the correct details.");
		}
	}
	
	public List<UserEntity> getUserFromDB(User user) {
		List<UserEntity> savedUser = getUserService.getUser(user.getEmail());
		return savedUser;
	}
	
	public boolean isUserDetailsMatchedWithExistingUser(List<UserEntity> savedUser) {
		return (savedUser != null && savedUser.size() > 0 && savedUser.get(0).getPassword().equals(Utility.getMD5(user.getPassword())));
	}
	
	public User getUserFromUserEntity(UserEntity userEntity) {
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		return user;
	}

}
