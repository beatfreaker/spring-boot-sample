package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
	
	List<UserEntity> findByEmail (String email);
	
}
