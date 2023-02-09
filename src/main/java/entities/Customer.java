package entities;

public class Customer {
	private int id;
	private String pseudonyme;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	public Customer(int id, String pseudonyme, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.pseudonyme = pseudonyme;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public String getPseudonyme() {
		return pseudonyme;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
