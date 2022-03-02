package com.cda.pc.Models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Panier {


	private String user;
<<<<<<< HEAD
=======
	private Collection<Computer> computers;
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
	private float price;
	
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
=======
	public Panier(String user, Collection<Computer> computers, float price) {
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
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
<<<<<<< HEAD
	}
=======
	public Collection<Computer> getComputers() {
		return computers;
	}
	public void setComputers(Collection<Computer> computers) {
		this.computers = computers;
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
