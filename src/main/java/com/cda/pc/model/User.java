package com.cda.pc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String pseudo;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "user")
    private List<Comment> comments;
	
	protected User() {}
	
	public User(long id, String name, String pseudo, String email, String password) {
		this.id = id;
		this.name = name;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String pseudo, String email, String password) {
		this.name = name;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
