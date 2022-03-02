
import java.util.Collection;

import javax.persistence.Entity;
@Entity
public class Wish {
	
	private String user;
<<<<<<< HEAD
=======
	private Collection<Computer> computers;
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
	public Wish() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
=======
	public Wish(String user, Collection<Computer> computers) {
>>>>>>> 9015d6a4272ca136848a4779042e4fd007932b27
		super();
		this.user = user;
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
	
	
}
