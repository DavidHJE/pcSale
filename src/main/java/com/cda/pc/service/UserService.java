package com.cda.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.pc.model.User;
import com.cda.pc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
}
