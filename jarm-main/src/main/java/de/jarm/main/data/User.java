package de.jarm.main.data;


public class User {
	private int id;
	private String name;
	private String password;
	//Unnecessary
	private String email;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id, String name, String password) {
		this(id, name, password, null);
	}
	
	public User(int id, String name, String password, String email) {
		setId(id);
		setName(name);
		setPassword(password);
		setEmail(email);
		
	}


	void setName(String name) {
		this.name = name;
	}
	
	int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	String getPassword() {
		return password;
	}
	
	String getName() {
		return name;
	}
}