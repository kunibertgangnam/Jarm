package classes;

public class User {
	private String username;
	private String password;
	private long userID;
	
	void changePassword(String password) {
		this.password = password;
	}
	
	public User(String username, String password, long userID) {
		this.username = username;
		this.password = password;
	}

	void changeName(String username) {
		this.username = username;
	}
	
	long getUserID() {
		return userID;
	}
	
	String getPassword() {
		return password;
	}
	
	String getUser() {
		return username;
	}
}