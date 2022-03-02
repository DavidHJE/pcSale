
import java.util.AbstractCollection;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD

=======
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
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
	
<<<<<<< HEAD
	private String status;
	
	
=======
	private Collection<Computer>computers;
	private String status;
	
	public Order(int id, float price, String user, Collection<Computer> computers, String status) {
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
		super();
		this.id = id;
		this.price = price;
		this.user = user;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
