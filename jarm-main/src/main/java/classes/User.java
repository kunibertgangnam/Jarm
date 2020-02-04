package classes;


public class User {
	private int iD;
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
	
	public User(int iD, String name, String password) {
		this(iD, name, password, null);
	}
	
	public User(int iD, String name, String password, String email) {
		setID(iD);
		setName(name);
		setPassword(password);
		setEmail(email);
		
	}


	void setName(String name) {
		this.name = name;
	}
	
	int getID() {
		return iD;
	}
	
	private void setID(int iD) {
		this.iD = iD;
	}
	
	String getPassword() {
		return password;
	}
	
	String getName() {
		return name;
	}
}