package interfaces;

public class Benutzer {
	private String username;
	private String password;
	
	void changePassword(String password) {
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
