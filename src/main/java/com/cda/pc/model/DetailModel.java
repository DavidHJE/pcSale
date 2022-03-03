package com.cda.pc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

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
	
	 @OneToOne
	 @JoinColumn(name = "computer_id")
	 private Computer computer;
	 
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
	

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}



	public DetailModel(String exploitation_systeme, String processeur, String carte_graphique, String stockage,
			String ram, Computer computer) {
		super();
		this.exploitation_systeme = exploitation_systeme;
		this.processeur = processeur;
		this.carte_graphique = carte_graphique;
		this.stockage = stockage;
		this.ram = ram;
		this.computer = computer;
	}



	
	

}
