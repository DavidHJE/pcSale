package com.cda.pc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstControlleur {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("page", "Index");
		
		return "index";
	}
}
