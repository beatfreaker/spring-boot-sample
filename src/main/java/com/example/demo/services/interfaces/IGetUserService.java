package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.entities.UserEntity;

public interface IGetUserService {
	public List<UserEntity> getUser(String email);
}
