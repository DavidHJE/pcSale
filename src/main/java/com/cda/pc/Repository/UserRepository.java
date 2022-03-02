package com.cda.pc.Repository;

import org.springframework.data.repository.CrudRepository;

import com.cda.pc.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
