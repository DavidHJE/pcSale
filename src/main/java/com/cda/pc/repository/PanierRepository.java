package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;
import com.cda.pc.model.Panier;

public interface PanierRepository extends  CrudRepository<Panier, Long>{

	Panier save(Panier panier);
}
