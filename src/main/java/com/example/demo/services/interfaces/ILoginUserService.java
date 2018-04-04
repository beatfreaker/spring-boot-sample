package com.example.demo.services.interfaces;

import javax.ws.rs.core.Response;
import com.example.demo.models.User;

public interface ILoginUserService {
	public Response loginUser(User user);
}
