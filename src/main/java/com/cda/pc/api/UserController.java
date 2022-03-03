package com.cda.pc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.pc.model.User;
import com.cda.pc.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public Iterable<User> getAllUser() {
		return userRepo.findAll();
	}
}
