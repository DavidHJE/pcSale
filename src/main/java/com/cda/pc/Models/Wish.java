package entities;

import java.util.Collection;

import javax.persistence.Entity;
@Entity
public class Wish {

	
	private String user;
	private Collection<Computers>computers;
	public Wish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wish(String user, Collection<Computers> computers) {
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
	public Collection<Computers> getComputers() {
		return computers;
	}
	public void setComputers(Collection<Computers> computers) {
		this.computers = computers;
	}
	
	
}
