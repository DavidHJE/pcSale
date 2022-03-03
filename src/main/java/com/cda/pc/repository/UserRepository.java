package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cda.pc.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
