package com.example.demo.services.interfaces;

import com.example.demo.entities.UserEntity;
import com.example.demo.models.User;
import javax.ws.rs.core.Response;

public interface ISaveUserService {
	public Response saveUser(User user);
}
