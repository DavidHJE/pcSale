package com.cda.pc.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Panier {
	
	@Id
	private String user; 
	private float price;
	
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panier(String user, Collection<Computer> computer, float price) {
		super();
		this.user = user;
		this.price = price;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
