package classes;

public class User {
	private long userID;
	private String username;
	private String password;

	
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