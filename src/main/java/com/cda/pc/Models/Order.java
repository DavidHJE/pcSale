package entities;
package com.cda.pc.Models;

import java.util.AbstractCollection;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	
	private int id;
	private float price;
	private String user;
	
	private Collection<Computer>computer;
	private String status;
	
	
	public Order(int id, float price, String user, Collection<Computer> computer, String status) {
		super();
		this.id = id;
		this.price = price;
		this.user = user;
		this.computer= computer;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
