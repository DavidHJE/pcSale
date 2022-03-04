package com.cda.pc.api;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.pc.model.Computer;
import com.cda.pc.model.DetailModel;
import com.cda.pc.repository.ComputerRepository;

import lombok.CustomLog;

@RestController
@RequestMapping("/api")
public class ComputerRestController {
	
	@Autowired
	private ComputerRepository repository;

	@GetMapping("computer")
	public Iterable<Computer> findAll() {
		return repository.findAll();
	}

	@RequestMapping(path="computer/add",consumes="application/json")
	//@PostMapping("computer/add")
	public ResponseEntity<Computer> create(@RequestBody Computer computer) {

		Computer _computer = repository.save(new Computer(computer.getId(),

				computer.getName(), computer.getMark(), computer.getPrice(), computer.getStock(),
				computer.getCategory()));

		return new ResponseEntity<>(_computer, HttpStatus.CREATED);

	}

	@GetMapping("computer/view/{id}")
	public Computer show(@PathVariable("id") long id, Model model) {

		Computer computer = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("computer", computer);
		return computer;
	}

	@PutMapping("computer/update/{id}")
	public ResponseEntity<Computer> update(@PathVariable("id") long id,Computer computer) {
		Optional<Computer> computerData = repository.findById(id);
		if (computerData.isPresent()) {
			Computer _computer = computerData.get();
			_computer.setId(computer.getId());
			_computer.setName(computer.getName());
			_computer.setMark(computer.getMark());
			_computer.setPrice(computer.getPrice());
			_computer.setStock(computer.getStock());
			_computer.setCategory(_computer.getCategory());
			_computer.setDetail(_computer.getDetail());

			return new ResponseEntity<>(repository.save(_computer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("computer/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {

		repository.deleteById(id);

		return "La fiche est supprimer" + id;
	}
}
