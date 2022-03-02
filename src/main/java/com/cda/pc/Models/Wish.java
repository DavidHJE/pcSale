package com.cda.pc.Models;

import java.util.Collection;

import javax.persistence.Entity;
@Entity
public class Wish {
	
	private String user;
	private Collection<Computer> computers;
	public Wish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wish(String user, Collection<Computer> computers) {
		super();
		this.user = user;
		this.computers = computers;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Collection<Computer> getComputers() {
		return computers;
	}
	public void setComputers(Collection<Computer> computers) {
		this.computers = computers;
	}
	
	
}
