package com.cda.pc.Models;

import java.util.Collection;

import javax.persistence.Entity;
@Entity
public class Wish {

	
	private String user;
	private Collection<Computer>computer;
	public Wish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wish(String user, Collection<Computer> computer) {
		super();
		this.user = user;
		this.computer = computer;
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
	
	
}
