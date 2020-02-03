package interfaces;

public class User {
	private String username;
	private String password;
	
	void changePassword(String password) {
		this.password = password;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	void changeName(String username) {
		this.username = username;
	}
	
	String getPassword() {
		return password;
	}
	
	String getUser() {
		return username;
	}
}
