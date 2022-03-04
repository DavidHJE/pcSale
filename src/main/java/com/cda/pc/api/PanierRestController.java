package com.cda.pc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cda.pc.model.Panier;
import com.cda.pc.repository.PanierRepository;

public class PanierRestController {
	
	@Autowired
	private PanierRepository panierRepo;
	
	@GetMapping("/api/panier")
	public Iterable<Panier> findAll(){
		return panierRepo.findAll();
	}
	
	@GetMapping("/api/panier/{id}")
	public Panier findById(@PathVariable("id") Long id){
		return (Panier) panierRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
	}

	@DeleteMapping("/api/panier/{id}")
	  public void deletePanier(@PathVariable("id") Long id) {
		panierRepo.deleteById(id);
	  }
	
	@PostMapping("/api/panier")
	public ResponseEntity<Panier> createPanier(@RequestBody Panier panier) {

			Panier _panier = panierRepo.save(new Panier());
			return new ResponseEntity<>(_panier, HttpStatus.CREATED);
	}

}
