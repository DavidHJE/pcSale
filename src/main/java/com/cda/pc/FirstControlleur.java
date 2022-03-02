package com.cda.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControlleur {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/api/generate")
	public void generate() {
			for (int i = 1; i <= 10; i++) {
				User user = new User("name" + i, "pseudo" + i, "email" + i, "password" + i);
			
				userRepo.save(user);
			}
	}
}
