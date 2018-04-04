package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.entities.UserEntity;
import com.example.demo.services.interfaces.*;
import com.example.demo.services.implementation.*;
import com.example.demo.models.*;


@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public UserEntity reservation() {
		return new UserEntity();
	}
	
	@Bean
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean
	public ISaveUserService saveUserService() {
		return new SaveUserService();
	}
	
	@Bean
	public IGetUserService getUserService() {
		return new GetUserService();
	}
	
	@Bean
	public ILoginUserService loginUserService() {
		return new LoginUserService();
	}
}
