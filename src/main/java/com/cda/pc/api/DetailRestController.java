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
import org.springframework.web.bind.annotation.RestController;

import com.cda.pc.model.DetailModel;
import com.cda.pc.repository.DetailRepository;

@RestController
public class DetailRestController {

	@Autowired
	private DetailRepository repository;

	@PostMapping("/api/detail/add")
	public ResponseEntity<DetailModel> createTutorial(@RequestBody DetailModel detail) {

		DetailModel _detail = repository.save(new DetailModel(

				detail.getExploitation_systeme(), detail.getProcesseur(), detail.getCarte_graphique(),
				detail.getStockage(), detail.getRam(),detail.getComputer()));
		return new ResponseEntity<>(_detail, HttpStatus.CREATED);

	}

	@GetMapping("/api/detail/view/{id}")
	public DetailModel showDetail(@PathVariable("id") long id, Model model) {

		DetailModel detail = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("detail", detail);
		return detail;
	}

	@GetMapping("/api/detail/delete/{id}")
	public String deleteDetail(@PathVariable("id") long id, Model model) {

		repository.deleteById(id);

		return "La fiche est supprimer" + id;
	}

	

		
		@PutMapping("/api/detail/update/{id}")
		  public ResponseEntity<DetailModel>updateD(@PathVariable("id") long id, @RequestBody DetailModel detail) {
		    Optional<DetailModel> fiche = repository.findById(id);
		   
		    
		    if (fiche.isPresent()) {
		        DetailModel _fiche = fiche.get();
		        _fiche.setExploitation_systeme(detail.getExploitation_systeme());
		        _fiche.setProcesseur(detail.getProcesseur());
		        _fiche.setCarte_graphique(detail.getCarte_graphique());
		        _fiche.setStockage(detail.getStockage());
		        _fiche.setRam(detail.getRam());
		        _fiche.setComputer(detail.getComputer());
		        
		        repository.save(_fiche);
		      } 
		    
		      return new ResponseEntity<>(detail, HttpStatus.OK);
		}
		  }


