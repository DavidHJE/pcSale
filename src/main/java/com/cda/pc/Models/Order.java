package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	
	private Collection<Computers>computers;
	private String status;
	
	
	public Order(int id, float price, String user, collection<Computers> computers, String status) {
		super();
		this.id = id;
		this.price = price;
		this.user = user;
		this.computers = computers;
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


	public Collection<Computers> getComputers() {
		return computers;
	}


	public void setComputers(Collection<Computers> computers) {
		this.computers = computers;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
