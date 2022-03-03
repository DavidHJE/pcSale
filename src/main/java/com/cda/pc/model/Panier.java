package com.cda.pc.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Panier {


	private String user;
	private Collection<Computer>computer;
	private float price;
	
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panier(String user, Collection<Computer> computer, float price) {
		super();
		this.user = user;
		this.computer = computer;
		this.price = price;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Collection<Computer> getComputer() {
		return computer;
	}
	public void setComputer(Collection<Computer> computer) {
		this.computer = computer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
