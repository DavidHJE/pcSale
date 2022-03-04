package com.cda.pc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cda.pc.model.Computer;
import com.cda.pc.repository.ComputerRepository;

@RestController
public class ComputerRestController {
	
	@Autowired
	private ComputerRepository computerRepo;
	
	@GetMapping("/api/computer")
	public Iterable<Computer> findAll(){
		return computerRepo.findAll();
	}
	
	@GetMapping("/api/computer/{id}")
	public Computer findById(@PathVariable("id") Long id){
		return (Computer) computerRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
	}

	@DeleteMapping("/api/computer/{id}")
	  public void deleteComputer(@PathVariable("id") Long id) {
		computerRepo.deleteById(id);
	  }
	
	@PostMapping("/api/computer")
	public ResponseEntity<Computer> createComputer(@RequestBody Computer computer) {
		try {
			Computer _computer = computerRepo.save(new Computer(computer.getName(), computer.getMark(), computer.getPrice(), computer.getStock(), computer.getCategory()));
			return new ResponseEntity<>(_computer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
