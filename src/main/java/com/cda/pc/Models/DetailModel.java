package com.cda.pc.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class DetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String exploitation_systeme;
	private String processeur;
	private String carte_graphique;
	private String stockage;
	private String ram;
	
	/*@OneToOne
	private int computer;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExploitation_systeme() {
		return exploitation_systeme;
	}

	public void setExploitation_systeme(String exploitation_systeme) {
		this.exploitation_systeme = exploitation_systeme;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public String getCarte_graphique() {
		return carte_graphique;
	}

	public void setCarte_graphique(String carte_graphique) {
		this.carte_graphique = carte_graphique;
	}

	public String getStockage() {
		return stockage;
	}

	public void setStockage(String stockage) {
		this.stockage = stockage;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}



	
	

}
